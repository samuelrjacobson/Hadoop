// cc AvgTemperatureReducer Reducer for maximum temperature example
// vv AvgTemperatureReducer
import java.io.IOException;

import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Reducer;

public class AvgTemperatureReducer
  extends Reducer<Text, IntWritable, Text, IntWritable> {
  
  @Override
  public void reduce(Text key, Iterable<IntWritable> values,
      Context context)
      throws IOException, InterruptedException {
    
    int sumValue = 0;
	int valuesSize = 0;
    for (IntWritable value : values) {
	  sumValue += value.get();
	  valuesSize++;
    }
	int avgValue = sumValue / valuesSize;
    context.write(key, new IntWritable(avgValue));
  }
}
// ^^ AvgTemperatureReducer
