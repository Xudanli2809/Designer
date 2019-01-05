package com.jojo.design.module_test.room;

import android.arch.persistence.db.SupportSQLiteDatabase;
import android.arch.persistence.room.Database;
import android.arch.persistence.room.RoomDatabase;
import android.arch.persistence.room.migration.Migration;

/**
 * author : JOJO
 * e-mail : 18510829974@163.com
 * date   : 2019/1/4 5:56 PM
 * desc   :
 */
//注解指定了database的表映射实体数据以及版本等信息
@Database(entities = {User.class}, version = 1)
public abstract class AppDatabase extends RoomDatabase {
    //RoomDatabase提供直接访问底层数据库实现，我们通过定义抽象方法返回具体Dao
//然后进行数据库增删该查的实现。
    public abstract UserDao userDao();

    //数据库变动添加Migration
    public static final Migration MIGRATION_1_2 = new Migration(1, 2) {
        @Override
        public void migrate(SupportSQLiteDatabase database) {
            database.execSQL("ALTER TABLE user "
                    + " ADD COLUMN age INTEGER NOT NULL DEFAULT 0");
        }
    };
}