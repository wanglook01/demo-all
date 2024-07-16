package org.example.filter;

import org.apache.logging.log4j.core.LogEvent;
import org.apache.logging.log4j.core.config.Configuration;
import org.apache.logging.log4j.core.config.plugins.Plugin;
import org.apache.logging.log4j.core.pattern.ConverterKeys;
import org.apache.logging.log4j.core.pattern.PatternConverter;
import org.apache.logging.log4j.core.pattern.ThrowablePatternConverter;

@Plugin(name = "CustomizedThrowablePatternConverter", category = PatternConverter.CATEGORY)
@ConverterKeys({"cc", "cusThrowable", "cusException"})
public class CustomizedThrowablePatternConverter extends ThrowablePatternConverter {

    protected CustomizedThrowablePatternConverter(String name,
                                                  String style,
                                                  String[] options,
                                                  Configuration config) {
        super(name, style, options, config);
    }

    //必须要有该方法
    public static ThrowablePatternConverter newInstance(final Configuration config, final String[] options) {
        return new CustomizedThrowablePatternConverter("Throwable2", "throwable", options, config);
    }


    @Override
    public void format(final LogEvent event, final StringBuilder buffer) {
        /*final ThrowableProxy proxy = event.getThrownProxy();
        Throwable throwable = event.getThrown();
        if ((throwable != null || proxy != null) && options.anyLines()) {
            if (proxy == null) {
                super.format(event, toAppendTo);
                return;
            }
            final int len = toAppendTo.length();
            if (len > 0 && !Character.isWhitespace(toAppendTo.charAt(len - 1))) {
                toAppendTo.append(' ');
            }
            //调用上面的工具类，格式化异常
            CustomizedThrowableProxyRenderer.formatExtendedStackTraceTo(proxy, toAppendTo, options.getIgnorePackages(),
                    options.getTextRenderer(), getSuffix(event), options.getSeparator());

    */
        super.format(event, buffer);
    }
}