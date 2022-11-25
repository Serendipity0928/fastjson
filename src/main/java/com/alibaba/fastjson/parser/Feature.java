/*
 * Copyright 1999-2017 Alibaba Group.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.alibaba.fastjson.parser;


/**
 * @author wenshao[szujobs@hotmail.com]
 */
public enum Feature {
    /**
	 * 决定了解析器是否将自动关闭那些不属于parser自己的输入源，如InputStream
     * 默认true;[默认见JSON.DEFAULT_PARSER_FEATURE，默认赋值在静态代码块中]
	 */
    AutoCloseSource,
    /**
	 * 该特性决定parser将是否允许解析使用Java/C++ 样式的注释（包括'/'+'*' 和'//' 变量）
     * 默认false;
	 */
    AllowComment,
    /**
	 * 这个特性决定parser是否将允许使用非双引号属性名字.
     * 默认true;
	 */
    AllowUnQuotedFieldNames,
    /**
	 * 该特性决定parser是否允许单引号来包住属性名称和字符串值。
     * 默认true;
	 */
    AllowSingleQuotes,
    /**
	 * 该特性决定JSON对象属性名称是否可以被String#intern 规范化表示.
     * 默认true;
	 */
    InternFieldNames,
    /**
	 * 该特性决定遇到字符串符合ISO8601格式的日期时，是否会会直接转换成日期类。
     * 默认false;
	 */
    AllowISO8601DateFormat,

    /**
     * 允许多重逗号,如果设为true,则遇到多个逗号会直接跳过;
     * 默认true;
     * {"a":1,,,"b":2}
     */
    AllowArbitraryCommas,

    /**
     * 设置为true则用BigDecimal类来装载数字，否则用的是double；
     * 默认true;
     */
    UseBigDecimal,
    
    /**
     * 忽略不匹配。
     * 默认true;
     * @since 1.1.2
     */
    IgnoreNotMatch,

    /**
     * fastjson序列化的文本，输出的结果是按照fieldName排序输出的，parser时也能利用这个顺序进行优化读取.
     * 默认true;
     * @since 1.1.3
     */
    SortFeidFastMatch,
    
    /**
     * 禁用ASM
     * 默认false;
     * @since 1.1.3
     */
    DisableASM,
    
    /**
     * 禁用循环引用检测
     * 默认false;
     * @since 1.1.7
     */
    DisableCircularReferenceDetect,
    
    /**
     * 没有值的字符串属性设置为空串
     * 默认false;
     * @since 1.1.10
     */
    InitStringFieldAsEmpty,
    
    /**
     * 支持数组to对象
     * 默认false;
     * @since 1.1.35
     * 
     */
    SupportArrayToBean,
    
    /**
     * 属性保持原来的顺序
     * 默认false;
     * @since 1.2.3
     * 
     */
    OrderedField,
    
    /**
     * 禁用特殊字符检查;
     * 默认false;
     * @since 1.2.5
     * 
     */
    DisableSpecialKeyDetect,
    
    /**
     * 使用对象数组
     * 默认false;
     * @since 1.2.9
     */
    UseObjectArray,

    /**
     * 如果目标类中私有变量没有setter方法，但是在反序列化时仍想给这个变量赋值.
     * 默认false;
     * @since 1.2.22, 1.1.54.android
     */
    SupportNonPublicField,

    /**
     * 禁用fastjson的AUTOTYPE特性，即不按照json字符串中的@type自动选择反序列化类
     * 默认false;
     * @since 1.2.29
     * disable autotype key '@type'
     */
    IgnoreAutoType,

    /**
     * 禁用属性智能匹配，例如下划线自动匹配驼峰等
     * 默认false;
     * @since 1.2.30
     * disable field smart match, improve performance in some scenarios.
     */
    DisableFieldSmartMatch,

    /**
     * 启用fastjson的autotype功能，即根据json字符串中的@type自动选择反序列化的类
     * 默认false;
     * @since 1.2.41, backport to 1.1.66.android
     */
    SupportAutoType,

    /**
     * 解析时将未用引号包含的json字段名作为String类型存储
     * 默认false; 序列化也会用这个属性，可在fastJson中设置parser.features.NonStringKeyAsString
     * @since 1.2.42
     */
    NonStringKeyAsString,

    /**
     * 自定义"{\"key\":value}"解析成Map实例，否则解析为JSONObject
     * 默认false;
     * @since 1.2.45
     */
    CustomMapDeserializer,

    /**
     * 枚举未匹配到时抛出异常，否则解析为null
     * 默认false; 序列化时这个属性可通过fastjson.properties配置parser.features.ErrorOnEnumNotMatch或fastjson.parser.features.ErrorOnEnumNotMatc
     * @since 1.2.55
     */
    ErrorOnEnumNotMatch,

    /**
     * 安全模式；
     * 默认false;
     * @since 1.2.68
     */
    SafeMode,

    /**
     * 字符串字段去除两头空字符
     * 默认false;
     * @since 1.2.72
     */
    TrimStringFieldValue,

    /**
     * @since 1.2.77
     * use HashMap instead of JSONObject, ArrayList instead of JSONArray
     */
    UseNativeJavaObject
    ;

    Feature(){
        mask = (1 << ordinal());
    }

    public final int mask;

    public final int getMask() {
        return mask;
    }

    public static boolean isEnabled(int features, Feature feature) {
        return (features & feature.mask) != 0;
    }

    /**
     * 根据传入的feature来调整features特征值。
     * @param features 原有特征值
     * @param feature 待处理特征值
     * @param state true:添加；false:去除
     * @return 处理后特征值
     */
    public static int config(int features, Feature feature, boolean state) {
        if (state) {
            features |= feature.mask;
        } else {
            features &= ~feature.mask;
        }

        return features;
    }
    
    public static int of(Feature[] features) {
        if (features == null) {
            return 0;
        }
        
        int value = 0;
        
        for (Feature feature: features) {
            value |= feature.mask;
        }
        
        return value;
    }
}
