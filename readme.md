## 说明

---

### 运行任务

* select job

```shell
hdfs dfs -mkdir -p /srv/mr_demo/input/SelectClauseMRJob
hdfs dfs -mkdir -p /srv/mr_demo/output/
hdfs dfs -rm -r /srv/mr_demo/output/SelectClauseMRJob/
hdfs dfs -copyFromLocal input/SelectClauseMRJob/* /srv/mr_demo/input/SelectClauseMRJob
hadoop  jar target/MRDemo-1.0-SNAPSHOT.jar com.zw.mr.SelectClauseMRJobRunner \
  /srv/mr_demo/input/SelectClauseMRJob/ \
  /srv/mr_demo/output/SelectClauseMRJob/
```

