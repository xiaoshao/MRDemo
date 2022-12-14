package com.zw.mr;

import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.conf.Configured;
import org.apache.hadoop.fs.Path;
import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.NullWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Job;
import org.apache.hadoop.mapreduce.Mapper;
import org.apache.hadoop.mapreduce.lib.input.FileInputFormat;
import org.apache.hadoop.mapreduce.lib.input.TextInputFormat;
import org.apache.hadoop.mapreduce.lib.output.FileOutputFormat;
import org.apache.hadoop.mapreduce.lib.output.TextOutputFormat;
import org.apache.hadoop.util.GenericOptionsParser;
import org.apache.hadoop.util.Tool;
import org.apache.hadoop.util.ToolRunner;

import java.io.IOException;

public class SelectClauseMRJob extends Configured implements Tool{


    public static class SelectClauseMapper extends Mapper<LongWritable, Text, NullWritable, Text> {
        public void map(LongWritable key, Text value, Context context) throws IOException, InterruptedException {
            context.write(NullWritable.get(), value);
        }
    }

    @Override
    public int run(String[] args) throws Exception {
        Job job = Job.getInstance(getConf());
        job.setJarByClass(SelectClauseMRJob.class);
        job.setInputFormatClass(TextInputFormat.class);
        job.setOutputFormatClass(TextOutputFormat.class);

        job.setOutputKeyClass(NullWritable.class);
        job.setOutputValueClass(Text.class);

        job.setMapperClass(SelectClauseMapper.class);
        job.setNumReduceTasks(0);

        String[] args1 = new GenericOptionsParser(getConf(), args).getRemainingArgs();
        FileInputFormat.setInputPaths(job, new Path(args1[0]));
        FileOutputFormat.setOutputPath(job, new Path(args1[1]));

        boolean status = job.waitForCompletion(true);

        if (status) {
            return 0;
        } else {
            return 1;
        }
    }

//    public static void main(String[] args) throws Exception {
//        Configuration configuration = new Configuration();
//        ToolRunner.run(new SelectClauseMRJob(), args);
//    }


}
