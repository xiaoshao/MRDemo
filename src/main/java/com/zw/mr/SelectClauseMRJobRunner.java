package com.zw.mr;

import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.util.ToolRunner;

public class SelectClauseMRJobRunner {
    public static void main(String[] args) throws Exception {
        Configuration configuration = new Configuration();

        ToolRunner.run(new SelectClauseMRJob(), args);
    }
}
