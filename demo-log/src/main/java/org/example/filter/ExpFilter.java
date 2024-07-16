package org.example.filter;

import org.apache.logging.log4j.core.LogEvent;
import org.apache.logging.log4j.core.config.plugins.Plugin;
import org.apache.logging.log4j.core.filter.AbstractFilter;

import static org.apache.logging.log4j.core.Filter.Result.ACCEPT;
import static org.apache.logging.log4j.core.Filter.Result.DENY;

@Plugin(name = "MyCustomFilter", category = "Core", elementType = "filter")
public class ExpFilter  extends AbstractFilter {

   /* @Override
    public Result filter(final LogEvent event) {
        // 根据你的逻辑决定日志事件是否应被记录
        if (event.getMessage().getFormattedMessage().contains("myKeyWord")) {
            return ACCEPT; // 记录日志
        } else {
            return DENY; // 不记录日志
        }
    }
*/

}