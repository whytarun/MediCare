package com.medicare.database.db

import androidx.room.DatabaseConfiguration
import androidx.room.InvalidationTracker
import androidx.room.RoomDatabase
import androidx.room.RoomOpenHelper
import androidx.room.migration.AutoMigrationSpec
import androidx.room.migration.Migration
import androidx.room.util.TableInfo
import androidx.room.util.TableInfo.Companion.read
import androidx.room.util.dropFtsSyncTriggers
import androidx.sqlite.db.SupportSQLiteDatabase
import androidx.sqlite.db.SupportSQLiteOpenHelper
import com.medicare.database.dao.MedicineDao
import com.medicare.database.dao.MedicineDao_Impl
import com.medicare.database.dao.UserDao
import com.medicare.database.dao.UserDao_Impl
import java.lang.Class
import java.util.ArrayList
import java.util.HashMap
import java.util.HashSet
import javax.`annotation`.processing.Generated
import kotlin.Any
import kotlin.Lazy
import kotlin.String
import kotlin.Suppress
import kotlin.collections.List
import kotlin.collections.Map
import kotlin.collections.MutableList
import kotlin.collections.Set

@Generated(value = ["androidx.room.RoomProcessor"])
@Suppress(names = ["UNCHECKED_CAST", "DEPRECATION", "REDUNDANT_PROJECTION"])
public class AppDatabase_Impl : AppDatabase() {
  private val _medicineDao: Lazy<MedicineDao> = lazy {
    MedicineDao_Impl(this)
  }


  private val _userDao: Lazy<UserDao> = lazy {
    UserDao_Impl(this)
  }


  protected override fun createOpenHelper(config: DatabaseConfiguration): SupportSQLiteOpenHelper {
    val _openCallback: SupportSQLiteOpenHelper.Callback = RoomOpenHelper(config, object :
        RoomOpenHelper.Delegate(1) {
      public override fun createAllTables(db: SupportSQLiteDatabase) {
        db.execSQL("CREATE TABLE IF NOT EXISTS `medicine` (`id` INTEGER, `name` TEXT NOT NULL, `dose` TEXT NOT NULL, `strength` TEXT NOT NULL, PRIMARY KEY(`id`))")
        db.execSQL("CREATE TABLE IF NOT EXISTS `user` (`id` INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL, `userName` TEXT NOT NULL)")
        db.execSQL("CREATE TABLE IF NOT EXISTS room_master_table (id INTEGER PRIMARY KEY,identity_hash TEXT)")
        db.execSQL("INSERT OR REPLACE INTO room_master_table (id,identity_hash) VALUES(42, '7413064923706f844da59c6b84fe8adb')")
      }

      public override fun dropAllTables(db: SupportSQLiteDatabase) {
        db.execSQL("DROP TABLE IF EXISTS `medicine`")
        db.execSQL("DROP TABLE IF EXISTS `user`")
        val _callbacks: List<RoomDatabase.Callback>? = mCallbacks
        if (_callbacks != null) {
          for (_callback: RoomDatabase.Callback in _callbacks) {
            _callback.onDestructiveMigration(db)
          }
        }
      }

      public override fun onCreate(db: SupportSQLiteDatabase) {
        val _callbacks: List<RoomDatabase.Callback>? = mCallbacks
        if (_callbacks != null) {
          for (_callback: RoomDatabase.Callback in _callbacks) {
            _callback.onCreate(db)
          }
        }
      }

      public override fun onOpen(db: SupportSQLiteDatabase) {
        mDatabase = db
        internalInitInvalidationTracker(db)
        val _callbacks: List<RoomDatabase.Callback>? = mCallbacks
        if (_callbacks != null) {
          for (_callback: RoomDatabase.Callback in _callbacks) {
            _callback.onOpen(db)
          }
        }
      }

      public override fun onPreMigrate(db: SupportSQLiteDatabase) {
        dropFtsSyncTriggers(db)
      }

      public override fun onPostMigrate(db: SupportSQLiteDatabase) {
      }

      public override fun onValidateSchema(db: SupportSQLiteDatabase):
          RoomOpenHelper.ValidationResult {
        val _columnsMedicine: HashMap<String, TableInfo.Column> =
            HashMap<String, TableInfo.Column>(4)
        _columnsMedicine.put("id", TableInfo.Column("id", "INTEGER", false, 1, null,
            TableInfo.CREATED_FROM_ENTITY))
        _columnsMedicine.put("name", TableInfo.Column("name", "TEXT", true, 0, null,
            TableInfo.CREATED_FROM_ENTITY))
        _columnsMedicine.put("dose", TableInfo.Column("dose", "TEXT", true, 0, null,
            TableInfo.CREATED_FROM_ENTITY))
        _columnsMedicine.put("strength", TableInfo.Column("strength", "TEXT", true, 0, null,
            TableInfo.CREATED_FROM_ENTITY))
        val _foreignKeysMedicine: HashSet<TableInfo.ForeignKey> = HashSet<TableInfo.ForeignKey>(0)
        val _indicesMedicine: HashSet<TableInfo.Index> = HashSet<TableInfo.Index>(0)
        val _infoMedicine: TableInfo = TableInfo("medicine", _columnsMedicine, _foreignKeysMedicine,
            _indicesMedicine)
        val _existingMedicine: TableInfo = read(db, "medicine")
        if (!_infoMedicine.equals(_existingMedicine)) {
          return RoomOpenHelper.ValidationResult(false, """
              |medicine(com.medicare.database.model.Medicine).
              | Expected:
              |""".trimMargin() + _infoMedicine + """
              |
              | Found:
              |""".trimMargin() + _existingMedicine)
        }
        val _columnsUser: HashMap<String, TableInfo.Column> = HashMap<String, TableInfo.Column>(2)
        _columnsUser.put("id", TableInfo.Column("id", "INTEGER", true, 1, null,
            TableInfo.CREATED_FROM_ENTITY))
        _columnsUser.put("userName", TableInfo.Column("userName", "TEXT", true, 0, null,
            TableInfo.CREATED_FROM_ENTITY))
        val _foreignKeysUser: HashSet<TableInfo.ForeignKey> = HashSet<TableInfo.ForeignKey>(0)
        val _indicesUser: HashSet<TableInfo.Index> = HashSet<TableInfo.Index>(0)
        val _infoUser: TableInfo = TableInfo("user", _columnsUser, _foreignKeysUser, _indicesUser)
        val _existingUser: TableInfo = read(db, "user")
        if (!_infoUser.equals(_existingUser)) {
          return RoomOpenHelper.ValidationResult(false, """
              |user(com.medicare.database.model.User).
              | Expected:
              |""".trimMargin() + _infoUser + """
              |
              | Found:
              |""".trimMargin() + _existingUser)
        }
        return RoomOpenHelper.ValidationResult(true, null)
      }
    }, "7413064923706f844da59c6b84fe8adb", "b740d26216be09f97bbc536484f14d64")
    val _sqliteConfig: SupportSQLiteOpenHelper.Configuration =
        SupportSQLiteOpenHelper.Configuration.builder(config.context).name(config.name).callback(_openCallback).build()
    val _helper: SupportSQLiteOpenHelper = config.sqliteOpenHelperFactory.create(_sqliteConfig)
    return _helper
  }

  protected override fun createInvalidationTracker(): InvalidationTracker {
    val _shadowTablesMap: HashMap<String, String> = HashMap<String, String>(0)
    val _viewTables: HashMap<String, Set<String>> = HashMap<String, Set<String>>(0)
    return InvalidationTracker(this, _shadowTablesMap, _viewTables, "medicine","user")
  }

  public override fun clearAllTables() {
    super.assertNotMainThread()
    val _db: SupportSQLiteDatabase = super.openHelper.writableDatabase
    try {
      super.beginTransaction()
      _db.execSQL("DELETE FROM `medicine`")
      _db.execSQL("DELETE FROM `user`")
      super.setTransactionSuccessful()
    } finally {
      super.endTransaction()
      _db.query("PRAGMA wal_checkpoint(FULL)").close()
      if (!_db.inTransaction()) {
        _db.execSQL("VACUUM")
      }
    }
  }

  protected override fun getRequiredTypeConverters(): Map<Class<out Any>, List<Class<out Any>>> {
    val _typeConvertersMap: HashMap<Class<out Any>, List<Class<out Any>>> =
        HashMap<Class<out Any>, List<Class<out Any>>>()
    _typeConvertersMap.put(MedicineDao::class.java, MedicineDao_Impl.getRequiredConverters())
    _typeConvertersMap.put(UserDao::class.java, UserDao_Impl.getRequiredConverters())
    return _typeConvertersMap
  }

  public override fun getRequiredAutoMigrationSpecs(): Set<Class<out AutoMigrationSpec>> {
    val _autoMigrationSpecsSet: HashSet<Class<out AutoMigrationSpec>> =
        HashSet<Class<out AutoMigrationSpec>>()
    return _autoMigrationSpecsSet
  }

  public override
      fun getAutoMigrations(autoMigrationSpecs: Map<Class<out AutoMigrationSpec>, AutoMigrationSpec>):
      List<Migration> {
    val _autoMigrations: MutableList<Migration> = ArrayList<Migration>()
    return _autoMigrations
  }

  public override fun medicineDao(): MedicineDao = _medicineDao.value

  public override fun userDao(): UserDao = _userDao.value
}
