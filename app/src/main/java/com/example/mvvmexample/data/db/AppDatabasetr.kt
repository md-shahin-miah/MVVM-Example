//package com.example.mvvmexample.data.db
//
//import android.content.Context
//import androidx.room.Database
//import androidx.room.Room
//import androidx.room.RoomDatabase
//import com.example.mvvmexample.data.db.dao.QuoteDao
//import com.example.mvvmexample.data.db.entity.Quote
//
//@Database(
//    entities = [Quote::class],
//    version = 1
//)
//abstract class AppDatabase : RoomDatabase() {
//
//
//    abstract fun getQuoteDao(): QuoteDao
//
//    companion object {
//
//        @Volatile
//        private var instance: AppDatabase? = null
//        private val LOCK = Any()
//
//        operator fun invoke(context: Context) = instance ?: synchronized(LOCK) {
//            instance ?: buildDatabase(context).also {
//                instance = it
//            }
//        }
//
//        private fun buildDatabase(context: Context) =
//            Room.databaseBuilder(
//                context.applicationContext,
//                AppDatabase::class.java,
//                "MyDatabaset.db"
//            ).build()
//    }
//}