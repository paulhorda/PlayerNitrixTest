package com.example.playernitrixtest.data.local.cache.image

import android.content.Context
import com.bumptech.glide.Glide
import com.example.playernitrixtest.utils.Constants.FILE_TYPE
import com.example.playernitrixtest.utils.Constants.IMAGE_CACHE_NAME
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import java.io.File
import javax.inject.Inject

class ImageCacheHelperImpl @Inject constructor(
    private val context: Context
) : ImageCacheHelper {

    override suspend fun downloadAndCacheImage(imageUrl: String): String {
        val file = File(context.cacheDir, IMAGE_CACHE_NAME)
        if (!file.exists()) {
            file.mkdirs()
        }

        val fileName = imageUrl.hashCode().toString() + FILE_TYPE
        val imageFile = File(file, fileName)

        if (!imageFile.exists()) {
            withContext(Dispatchers.IO) {
                Glide.with(context)
                    .downloadOnly()
                    .load(imageUrl)
                    .submit()
                    .get()
                    .copyTo(imageFile)
            }
        }

        return imageFile.absolutePath
    }
}
