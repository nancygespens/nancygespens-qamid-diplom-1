package ru.iteco.fmhandroid.db;

import androidx.annotation.NonNull;
import androidx.room.DatabaseConfiguration;
import androidx.room.InvalidationTracker;
import androidx.room.RoomOpenHelper;
import androidx.room.RoomOpenHelper.Delegate;
import androidx.room.RoomOpenHelper.ValidationResult;
import androidx.room.migration.AutoMigrationSpec;
import androidx.room.migration.Migration;
import androidx.room.util.DBUtil;
import androidx.room.util.TableInfo;
import androidx.room.util.TableInfo.Column;
import androidx.room.util.TableInfo.ForeignKey;
import androidx.room.util.TableInfo.Index;
import androidx.sqlite.db.SupportSQLiteDatabase;
import androidx.sqlite.db.SupportSQLiteOpenHelper;
import androidx.sqlite.db.SupportSQLiteOpenHelper.Callback;
import androidx.sqlite.db.SupportSQLiteOpenHelper.Configuration;
import java.lang.Class;
import java.lang.Override;
import java.lang.String;
import java.lang.SuppressWarnings;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import ru.iteco.fmhandroid.dao.ClaimCommentDao;
import ru.iteco.fmhandroid.dao.ClaimCommentDao_Impl;
import ru.iteco.fmhandroid.dao.ClaimDao;
import ru.iteco.fmhandroid.dao.ClaimDao_Impl;
import ru.iteco.fmhandroid.dao.NewsCategoryDao;
import ru.iteco.fmhandroid.dao.NewsCategoryDao_Impl;
import ru.iteco.fmhandroid.dao.NewsDao;
import ru.iteco.fmhandroid.dao.NewsDao_Impl;

@SuppressWarnings({"unchecked", "deprecation"})
public final class AppDb_Impl extends AppDb {
  private volatile ClaimDao _claimDao;

  private volatile ClaimCommentDao _claimCommentDao;

  private volatile NewsDao _newsDao;

  private volatile NewsCategoryDao _newsCategoryDao;

  @Override
  protected SupportSQLiteOpenHelper createOpenHelper(DatabaseConfiguration configuration) {
    final SupportSQLiteOpenHelper.Callback _openCallback = new RoomOpenHelper(configuration, new RoomOpenHelper.Delegate(1) {
      @Override
      public void createAllTables(SupportSQLiteDatabase _db) {
        _db.execSQL("CREATE TABLE IF NOT EXISTS `ClaimEntity` (`id` INTEGER, `title` TEXT NOT NULL, `description` TEXT NOT NULL, `creatorId` INTEGER NOT NULL, `creatorName` TEXT NOT NULL, `executorId` INTEGER, `executorName` TEXT, `createDate` INTEGER NOT NULL, `planExecuteDate` INTEGER NOT NULL, `factExecuteDate` INTEGER, `status` TEXT NOT NULL, PRIMARY KEY(`id`))");
        _db.execSQL("CREATE TABLE IF NOT EXISTS `ClaimCommentEntity` (`id` INTEGER, `claimId` INTEGER NOT NULL, `description` TEXT NOT NULL, `creatorId` INTEGER NOT NULL, `creatorName` TEXT NOT NULL, `createDate` INTEGER NOT NULL, PRIMARY KEY(`id`))");
        _db.execSQL("CREATE TABLE IF NOT EXISTS `NewsEntity` (`id` INTEGER, `newsCategoryId` INTEGER NOT NULL, `title` TEXT NOT NULL, `description` TEXT NOT NULL, `creatorId` INTEGER NOT NULL, `creatorName` TEXT NOT NULL, `createDate` INTEGER NOT NULL, `publishDate` INTEGER NOT NULL, `publishEnabled` INTEGER NOT NULL, `isOpen` INTEGER NOT NULL, PRIMARY KEY(`id`))");
        _db.execSQL("CREATE TABLE IF NOT EXISTS `NewsCategoryEntity` (`id` INTEGER NOT NULL, `name` TEXT NOT NULL, `deleted` INTEGER NOT NULL, PRIMARY KEY(`id`))");
        _db.execSQL("CREATE TABLE IF NOT EXISTS room_master_table (id INTEGER PRIMARY KEY,identity_hash TEXT)");
        _db.execSQL("INSERT OR REPLACE INTO room_master_table (id,identity_hash) VALUES(42, '65a184ebbca087433fa16c9a55eaa869')");
      }

      @Override
      public void dropAllTables(SupportSQLiteDatabase _db) {
        _db.execSQL("DROP TABLE IF EXISTS `ClaimEntity`");
        _db.execSQL("DROP TABLE IF EXISTS `ClaimCommentEntity`");
        _db.execSQL("DROP TABLE IF EXISTS `NewsEntity`");
        _db.execSQL("DROP TABLE IF EXISTS `NewsCategoryEntity`");
        if (mCallbacks != null) {
          for (int _i = 0, _size = mCallbacks.size(); _i < _size; _i++) {
            mCallbacks.get(_i).onDestructiveMigration(_db);
          }
        }
      }

      @Override
      protected void onCreate(SupportSQLiteDatabase _db) {
        if (mCallbacks != null) {
          for (int _i = 0, _size = mCallbacks.size(); _i < _size; _i++) {
            mCallbacks.get(_i).onCreate(_db);
          }
        }
      }

      @Override
      public void onOpen(SupportSQLiteDatabase _db) {
        mDatabase = _db;
        internalInitInvalidationTracker(_db);
        if (mCallbacks != null) {
          for (int _i = 0, _size = mCallbacks.size(); _i < _size; _i++) {
            mCallbacks.get(_i).onOpen(_db);
          }
        }
      }

      @Override
      public void onPreMigrate(SupportSQLiteDatabase _db) {
        DBUtil.dropFtsSyncTriggers(_db);
      }

      @Override
      public void onPostMigrate(SupportSQLiteDatabase _db) {
      }

      @Override
      protected RoomOpenHelper.ValidationResult onValidateSchema(SupportSQLiteDatabase _db) {
        final HashMap<String, TableInfo.Column> _columnsClaimEntity = new HashMap<String, TableInfo.Column>(11);
        _columnsClaimEntity.put("id", new TableInfo.Column("id", "INTEGER", false, 1, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsClaimEntity.put("title", new TableInfo.Column("title", "TEXT", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsClaimEntity.put("description", new TableInfo.Column("description", "TEXT", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsClaimEntity.put("creatorId", new TableInfo.Column("creatorId", "INTEGER", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsClaimEntity.put("creatorName", new TableInfo.Column("creatorName", "TEXT", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsClaimEntity.put("executorId", new TableInfo.Column("executorId", "INTEGER", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsClaimEntity.put("executorName", new TableInfo.Column("executorName", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsClaimEntity.put("createDate", new TableInfo.Column("createDate", "INTEGER", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsClaimEntity.put("planExecuteDate", new TableInfo.Column("planExecuteDate", "INTEGER", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsClaimEntity.put("factExecuteDate", new TableInfo.Column("factExecuteDate", "INTEGER", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsClaimEntity.put("status", new TableInfo.Column("status", "TEXT", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        final HashSet<TableInfo.ForeignKey> _foreignKeysClaimEntity = new HashSet<TableInfo.ForeignKey>(0);
        final HashSet<TableInfo.Index> _indicesClaimEntity = new HashSet<TableInfo.Index>(0);
        final TableInfo _infoClaimEntity = new TableInfo("ClaimEntity", _columnsClaimEntity, _foreignKeysClaimEntity, _indicesClaimEntity);
        final TableInfo _existingClaimEntity = TableInfo.read(_db, "ClaimEntity");
        if (! _infoClaimEntity.equals(_existingClaimEntity)) {
          return new RoomOpenHelper.ValidationResult(false, "ClaimEntity(ru.iteco.fmhandroid.entity.ClaimEntity).\n"
                  + " Expected:\n" + _infoClaimEntity + "\n"
                  + " Found:\n" + _existingClaimEntity);
        }
        final HashMap<String, TableInfo.Column> _columnsClaimCommentEntity = new HashMap<String, TableInfo.Column>(6);
        _columnsClaimCommentEntity.put("id", new TableInfo.Column("id", "INTEGER", false, 1, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsClaimCommentEntity.put("claimId", new TableInfo.Column("claimId", "INTEGER", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsClaimCommentEntity.put("description", new TableInfo.Column("description", "TEXT", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsClaimCommentEntity.put("creatorId", new TableInfo.Column("creatorId", "INTEGER", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsClaimCommentEntity.put("creatorName", new TableInfo.Column("creatorName", "TEXT", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsClaimCommentEntity.put("createDate", new TableInfo.Column("createDate", "INTEGER", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        final HashSet<TableInfo.ForeignKey> _foreignKeysClaimCommentEntity = new HashSet<TableInfo.ForeignKey>(0);
        final HashSet<TableInfo.Index> _indicesClaimCommentEntity = new HashSet<TableInfo.Index>(0);
        final TableInfo _infoClaimCommentEntity = new TableInfo("ClaimCommentEntity", _columnsClaimCommentEntity, _foreignKeysClaimCommentEntity, _indicesClaimCommentEntity);
        final TableInfo _existingClaimCommentEntity = TableInfo.read(_db, "ClaimCommentEntity");
        if (! _infoClaimCommentEntity.equals(_existingClaimCommentEntity)) {
          return new RoomOpenHelper.ValidationResult(false, "ClaimCommentEntity(ru.iteco.fmhandroid.entity.ClaimCommentEntity).\n"
                  + " Expected:\n" + _infoClaimCommentEntity + "\n"
                  + " Found:\n" + _existingClaimCommentEntity);
        }
        final HashMap<String, TableInfo.Column> _columnsNewsEntity = new HashMap<String, TableInfo.Column>(10);
        _columnsNewsEntity.put("id", new TableInfo.Column("id", "INTEGER", false, 1, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsNewsEntity.put("newsCategoryId", new TableInfo.Column("newsCategoryId", "INTEGER", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsNewsEntity.put("title", new TableInfo.Column("title", "TEXT", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsNewsEntity.put("description", new TableInfo.Column("description", "TEXT", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsNewsEntity.put("creatorId", new TableInfo.Column("creatorId", "INTEGER", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsNewsEntity.put("creatorName", new TableInfo.Column("creatorName", "TEXT", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsNewsEntity.put("createDate", new TableInfo.Column("createDate", "INTEGER", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsNewsEntity.put("publishDate", new TableInfo.Column("publishDate", "INTEGER", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsNewsEntity.put("publishEnabled", new TableInfo.Column("publishEnabled", "INTEGER", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsNewsEntity.put("isOpen", new TableInfo.Column("isOpen", "INTEGER", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        final HashSet<TableInfo.ForeignKey> _foreignKeysNewsEntity = new HashSet<TableInfo.ForeignKey>(0);
        final HashSet<TableInfo.Index> _indicesNewsEntity = new HashSet<TableInfo.Index>(0);
        final TableInfo _infoNewsEntity = new TableInfo("NewsEntity", _columnsNewsEntity, _foreignKeysNewsEntity, _indicesNewsEntity);
        final TableInfo _existingNewsEntity = TableInfo.read(_db, "NewsEntity");
        if (! _infoNewsEntity.equals(_existingNewsEntity)) {
          return new RoomOpenHelper.ValidationResult(false, "NewsEntity(ru.iteco.fmhandroid.entity.NewsEntity).\n"
                  + " Expected:\n" + _infoNewsEntity + "\n"
                  + " Found:\n" + _existingNewsEntity);
        }
        final HashMap<String, TableInfo.Column> _columnsNewsCategoryEntity = new HashMap<String, TableInfo.Column>(3);
        _columnsNewsCategoryEntity.put("id", new TableInfo.Column("id", "INTEGER", true, 1, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsNewsCategoryEntity.put("name", new TableInfo.Column("name", "TEXT", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsNewsCategoryEntity.put("deleted", new TableInfo.Column("deleted", "INTEGER", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        final HashSet<TableInfo.ForeignKey> _foreignKeysNewsCategoryEntity = new HashSet<TableInfo.ForeignKey>(0);
        final HashSet<TableInfo.Index> _indicesNewsCategoryEntity = new HashSet<TableInfo.Index>(0);
        final TableInfo _infoNewsCategoryEntity = new TableInfo("NewsCategoryEntity", _columnsNewsCategoryEntity, _foreignKeysNewsCategoryEntity, _indicesNewsCategoryEntity);
        final TableInfo _existingNewsCategoryEntity = TableInfo.read(_db, "NewsCategoryEntity");
        if (! _infoNewsCategoryEntity.equals(_existingNewsCategoryEntity)) {
          return new RoomOpenHelper.ValidationResult(false, "NewsCategoryEntity(ru.iteco.fmhandroid.entity.NewsCategoryEntity).\n"
                  + " Expected:\n" + _infoNewsCategoryEntity + "\n"
                  + " Found:\n" + _existingNewsCategoryEntity);
        }
        return new RoomOpenHelper.ValidationResult(true, null);
      }
    }, "65a184ebbca087433fa16c9a55eaa869", "15ead7323ca534b5c05ea4dd98e912d8");
    final SupportSQLiteOpenHelper.Configuration _sqliteConfig = SupportSQLiteOpenHelper.Configuration.builder(configuration.context)
        .name(configuration.name)
        .callback(_openCallback)
        .build();
    final SupportSQLiteOpenHelper _helper = configuration.sqliteOpenHelperFactory.create(_sqliteConfig);
    return _helper;
  }

  @Override
  protected InvalidationTracker createInvalidationTracker() {
    final HashMap<String, String> _shadowTablesMap = new HashMap<String, String>(0);
    HashMap<String, Set<String>> _viewTables = new HashMap<String, Set<String>>(0);
    return new InvalidationTracker(this, _shadowTablesMap, _viewTables, "ClaimEntity","ClaimCommentEntity","NewsEntity","NewsCategoryEntity");
  }

  @Override
  public void clearAllTables() {
    super.assertNotMainThread();
    final SupportSQLiteDatabase _db = super.getOpenHelper().getWritableDatabase();
    try {
      super.beginTransaction();
      _db.execSQL("DELETE FROM `ClaimEntity`");
      _db.execSQL("DELETE FROM `ClaimCommentEntity`");
      _db.execSQL("DELETE FROM `NewsEntity`");
      _db.execSQL("DELETE FROM `NewsCategoryEntity`");
      super.setTransactionSuccessful();
    } finally {
      super.endTransaction();
      _db.query("PRAGMA wal_checkpoint(FULL)").close();
      if (!_db.inTransaction()) {
        _db.execSQL("VACUUM");
      }
    }
  }

  @Override
  protected Map<Class<?>, List<Class<?>>> getRequiredTypeConverters() {
    final HashMap<Class<?>, List<Class<?>>> _typeConvertersMap = new HashMap<Class<?>, List<Class<?>>>();
    _typeConvertersMap.put(ClaimDao.class, ClaimDao_Impl.getRequiredConverters());
    _typeConvertersMap.put(ClaimCommentDao.class, ClaimCommentDao_Impl.getRequiredConverters());
    _typeConvertersMap.put(NewsDao.class, NewsDao_Impl.getRequiredConverters());
    _typeConvertersMap.put(NewsCategoryDao.class, NewsCategoryDao_Impl.getRequiredConverters());
    return _typeConvertersMap;
  }

  @Override
  public Set<Class<? extends AutoMigrationSpec>> getRequiredAutoMigrationSpecs() {
    final HashSet<Class<? extends AutoMigrationSpec>> _autoMigrationSpecsSet = new HashSet<Class<? extends AutoMigrationSpec>>();
    return _autoMigrationSpecsSet;
  }

  @Override
  public List<Migration> getAutoMigrations(
      @NonNull Map<Class<? extends AutoMigrationSpec>, AutoMigrationSpec> autoMigrationSpecsMap) {
    return Arrays.asList();
  }

  @Override
  public ClaimDao getClaimDao() {
    if (_claimDao != null) {
      return _claimDao;
    } else {
      synchronized(this) {
        if(_claimDao == null) {
          _claimDao = new ClaimDao_Impl(this);
        }
        return _claimDao;
      }
    }
  }

  @Override
  public ClaimCommentDao getClaimCommentDao() {
    if (_claimCommentDao != null) {
      return _claimCommentDao;
    } else {
      synchronized(this) {
        if(_claimCommentDao == null) {
          _claimCommentDao = new ClaimCommentDao_Impl(this);
        }
        return _claimCommentDao;
      }
    }
  }

  @Override
  public NewsDao getNewsDao() {
    if (_newsDao != null) {
      return _newsDao;
    } else {
      synchronized(this) {
        if(_newsDao == null) {
          _newsDao = new NewsDao_Impl(this);
        }
        return _newsDao;
      }
    }
  }

  @Override
  public NewsCategoryDao getNewsCategoryDao() {
    if (_newsCategoryDao != null) {
      return _newsCategoryDao;
    } else {
      synchronized(this) {
        if(_newsCategoryDao == null) {
          _newsCategoryDao = new NewsCategoryDao_Impl(this);
        }
        return _newsCategoryDao;
      }
    }
  }
}
