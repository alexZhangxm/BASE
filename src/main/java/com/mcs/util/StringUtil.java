package com.mcs.util;

import java.math.BigDecimal;
import java.net.NetworkInterface;
import java.net.URLDecoder;
import java.net.URLEncoder;
import java.security.MessageDigest;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.TreeMap;
import java.util.regex.Pattern;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.math.NumberUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.mcs.entity.Page;

/**
 * @ClassName StringUtil
 * @Description:字符串处理工具类
 * @author zhangxm
 * @date 2016年6月8日 下午4:56:30
 */
public class StringUtil extends StringUtils
{
    
    private static Log log = LogFactory.getLog(StringUtil.class);
    
    // 用于检验emial的正则表达式
    public static final String EMAIL_REGEX = "^[\\w-]+(\\.[\\w-]+)*@[\\w-]+(\\.[\\w-]+)+$";
    
    // 用于检验手机的正则表达式
    public static final String PHONE_REGEX = "^(13[0-9]|15[0-9]|18[0-9]|17[0-9])\\d{8}$";// "^(13[0-9]|15[^4]|18[0-9])\\d{8}$";
    
    /**
     * 字符串MD5加密
     * 
     * @param value
     * @return
     * @throws Exception
     */
    public static String md5(String value)
        throws Exception
    {
        if (value == null || "".equals(value))
        {
            return "";
        }
        StringBuffer result = new StringBuffer("");
        MessageDigest md = MessageDigest.getInstance("MD5");
        md.update(value.getBytes());
        byte[] bt = md.digest();
        int idx = 0;
        for (int i = 0; i < bt.length; i++)
        {
            idx = bt[i];
            if (idx < 0)
            {
                idx += 256;
            }
            if (idx < 16)
            {
                result.append("0");
            }
            result.append(Integer.toHexString(idx));
        }
        return result.toString();
    }
    
    /**
     * 连接URL地址，并添加随机数
     * 
     * @param values 数组
     * @return
     */
    public static String getUrl(Object... values)
    {
        return StringUtils.join(values, "/") + "?r=" + new Random().nextInt(10000);
    }
    
    /**
     * 拼接URL
     * 
     * @param values
     * @return
     */
    public static String joinUrl(Object... values)
    {
        return StringUtils.join(values, "/");
    }
    
    /**
     * 解码字符串
     * 
     * @param value
     * @param charset
     * @return
     * @throws Exception
     */
    public static String decode(String value, String charset)
    {
        if (StringUtils.isEmpty(value))
        {
            return "";
        }
        try
        {
            return new String(value.getBytes("ISO-8859-1"), charset).trim();
        }
        catch (Exception e)
        {
            log.error("解码字符串出错，原因：", e);
        }
        return null;
    }
    
    /**
     * 解码字符串
     * 
     * @param value
     * @return
     * @throws Exception
     */
    public static String decode(String value)
    {
        return StringUtil.decode(value, System.getProperty("file.encoding"));
    }
    
    /**
     * 解码字符串(中文)
     * 
     * @param value
     * @return
     */
    public static String decodeURI(String value)
    {
        if (StringUtils.isEmpty(value))
        {
            return null;
        }
        try
        {
            return URLDecoder.decode(value, "UTF-8");
        }
        catch (Exception e)
        {
            log.error("解码字符串出错，原因：", e);
        }
        return null;
    }
    
    /**
     * 编码字符串(中文)
     * 
     * @param value
     * @return
     */
    public static String encodeURI(String value)
    {
        if (StringUtils.isEmpty(value))
        {
            return "";
        }
        try
        {
            return URLEncoder.encode(value, "UTF-8");
        }
        catch (Exception e)
        {
            log.error("编码字符串出错，原因：", e);
        }
        return "";
    }
    
    /**
     * 编码HTML
     * 
     * @param value
     * @return
     */
    public static String encodeHTML(String value)
    {
        if (StringUtils.isEmpty(value))
        {
            return "";
        }
        return value.replace("<", "&lt").replace(">", "&gt");
    }
    
    /**
     * 判断字符是否为中文
     * 
     * @param ch
     * @return
     */
    private static boolean isChineseChar(char ch)
    {
        try
        {
            return String.valueOf(ch).getBytes("GBK").length > 1;
        }
        catch (Exception e)
        {
            log.error("字符编码不存在，原因：" + e);
            return false;
        }
    }
    
    /**
     * 按字节截取指定长度
     * 
     * @param value
     * @param count
     * @return
     */
    public static String substrForByte(String value, Integer count)
    {
        if (StringUtils.isEmpty(value))
        {
            return null;
        }
        char[] values = value.toCharArray();
        StringBuffer data = new StringBuffer();
        int i = 1;
        for (char ch : values)
        {
            if (i > count)
            {
                break;
            }
            if (StringUtil.isChineseChar(ch))
            {
                i += 2;
            }
            else
            {
                i += 1;
            }
            data.append(ch);
        }
        return data.toString();
    }
    
    /**
     * 截断字符串(从字符串后方开始截断)
     * 
     * @param value 需要截取的对象
     * @param length 需要截断的长度
     * @return
     */
    public static String substr(Object value, int length)
    {
        if (value == null || StringUtil.isEmpty(value.toString()))
        {
            return "";
        }
        int len = value.toString().length();
        return value.toString().substring(0, len - length);
    }
    
    /**
     * 截断字符串(从字符串后方开始截断),截断最后一个字符
     * 
     * @param value 需要截取的对象
     * @return
     */
    public static String substr(Object value)
    {
        return StringUtil.substr(value, 1);
    }
    
    /**
     * 获取字符个数，一个中文算一个长度，两个英文算一个长度
     * 
     * @param value
     * @return
     */
    public static int length(String value)
    {
        // 字符长度
        int allLen = value.length();
        // 英文字符长度
        int enLen = value.replaceAll("[^x00-xff]", "").length();
        return (enLen % 2 == 0 ? enLen / 2 : (enLen / 2) + 1) + (allLen - enLen);
    }
    
    /**
     * 获取客户端请求的IP地址
     * 
     * @param request 会话请求
     * @return
     */
    public static String getRemoteIP(HttpServletRequest request)
    {
        String ip = request.getHeader("X-Forwarded-For");
        if (StringUtils.isEmpty(ip) || "unknown".equalsIgnoreCase(ip))
        {
            ip = request.getHeader("Proxy-Client-IP");
        }
        if (StringUtils.isEmpty(ip) || "unknown".equalsIgnoreCase(ip))
        {
            ip = request.getHeader("WL-Proxy-Client-IP");
        }
        if (StringUtils.isEmpty(ip) || "unknown".equalsIgnoreCase(ip))
        {
            ip = request.getHeader("HTTP_CLIENT_IP");
        }
        if (StringUtils.isEmpty(ip) || "unknown".equalsIgnoreCase(ip))
        {
            ip = request.getHeader("HTTP_X_FORWARDED_FOR");
        }
        if (StringUtils.isEmpty(ip) || "unknown".equalsIgnoreCase(ip))
        {
            ip = request.getRemoteAddr();
        }
        return ip;
    }
    
    public static String getLocalIP()
    {
        try
        {
            Enumeration<NetworkInterface> e = NetworkInterface.getNetworkInterfaces();
            while (e.hasMoreElements())
            {
            }
        }
        catch (Exception e)
        {
            log.error("获取本机IP地址出错，原因：", e);
        }
        return null;
    }
    
    /**
     * 拼接流水号
     * 
     * @param value 需要拼接的值
     * @param count 流水号限制长度
     * @return
     */
    public static String flow(String value, Integer count)
    {
        if (!NumberUtils.isDigits(value))
        {
            return "";
        }
        String val = value.toString();
        int len = count - val.length();
        if (len <= 0)
        {
            return val;
        }
        String str = "";
        for (int i = 0; i < len; i++)
        {
            str += "0";
        }
        return str + val;
    }
    
    /**
     * 如果为空替换字符串
     * 
     * @param value
     * @param replace
     * @return
     */
    public static String parseStr(Object value, String replace)
    {
        if (value == null || "".equals(value.toString().trim()))
        {
            return replace;
        }
        return value.toString();
    }
    
    /**
     * 将数字格式化输出
     * 
     * @param value 需要格式化的值
     * @param precision 精度(小数点后的位数)
     * @return
     */
    public static String format(Object value, Integer precision)
    {
        if (value == null)
        {
            return "";
        }
        Double number = 0.0;
        if (NumberUtils.isNumber(value.toString()))
        {
            number = new Double(value.toString());
        }
        precision = (precision == null || precision < 0) ? 2 : precision;
        BigDecimal bigDecimal = new BigDecimal(number);
        return bigDecimal.setScale(precision, BigDecimal.ROUND_HALF_UP).toString();
    }
    
    /**
     * 将数字格式化输出,保留两位小数
     * 
     * @param value
     * @return
     */
    public static String format(Object value)
    {
        return StringUtil.format(value, 2);
    }
    
    /**
     * 获取指定长度的随机码
     * 
     * @param length 长度
     * @param hasCharacter 是否包含字符
     * @return
     */
    public static String getRandCode(int length, boolean hasCharacter)
    {
        StringBuffer code = new StringBuffer();
        Random rand = new Random();
        if (hasCharacter)
        {
            StringBuffer str = new StringBuffer("0A1B2C3D4E5F6G7H8I9J0K1L2M3N4O5P6Q7R8S9T0U1V2W3X4Y5Z");
            int len = str.length();
            for (int i = 0; i < length; i++)
            {
                code.append(str.charAt(rand.nextInt(len)));
            }
        }
        else
        {
            for (int i = 0; i < length; i++)
            {
                code.append(rand.nextInt(10));
            }
        }
        return code.toString();
    }
    
    /**
     * 获取指定长度的随机码(纯数字)
     * 
     * @param length 长度
     * @return
     */
    public static String getRandCode(int length)
    {
        return StringUtil.getRandCode(length, false);
    }
    
    /**
     * 按指定位数拆分随机码(以空格隔开)
     * 
     * @param code 随机码
     * @param len 位数
     * @return
     */
    public static String splitRandCode(String code, int len)
    {
        if (StringUtils.isEmpty(code))
        {
            return null;
        }
        StringBuffer data = new StringBuffer();
        int length = code.length();
        if (length < len)
        {
            return code;
        }
        int count = length / len;
        boolean hasMore = length % len != 0;
        int start = 0;
        int end = 0;
        for (int i = 0; i < count; i++)
        {
            start = i * len;
            end = start + len;
            data.append(code.substring(start, start + len)).append(" ");
        }
        if (hasMore)
        {
            data.append(code.substring(end));
        }
        else
        {
            data.deleteCharAt(data.length() - 1);
        }
        return data.toString();
        
    }
    
    /**
     * 验证邮箱格式是否合法
     * 
     * @param email
     * @return
     */
    public static boolean checkEmail(String email)
    {
        return Pattern.matches(EMAIL_REGEX, email);
    }
    
    /**
     * 验证手机格式是否合法
     * 
     * @param phone
     * @return
     */
    public static boolean checkPhone(String phone)
    {
        return Pattern.matches(PHONE_REGEX, phone);
    }
    
    /**
     * 替换rcontent标签中的文本
     * 
     * @param content
     * @param text
     * @return
     */
    public static String replaceContent(String content, String ntext)
    {
        if (StringUtils.isEmpty(content))
        {
            return null;
        }
        content = content.replace("\r", "").replace("\n", "");
        return content.replaceAll("<span class=\"rcontent\">.*?</span>", ntext);
    }
    
    /**
     * 数值转换
     * 
     * @param value
     * @return
     */
    public static String convertNumber(Object value)
    {
        String str = value.toString();
        int len = str.length();
        // 数值大于千万
        if (len > 7)
        {
            return "999万";
        }
        // 数值大于十万
        if (len > 6)
        {
            str = StringUtil.substr(str, 4);
            return str + "万";
        }
        // 数值大于万
        if (len > 5)
        {
            str = StringUtil.substr(str, 3);
            char ch = str.toCharArray()[str.length() - 1];
            String cha = StringUtil.substr(str, 1);
            return cha + "." + ch + "万";
        }
        return str;
    }
    
    public static String toStr(Object value)
    {
        if (value == null)
        {
            return "";
        }
        return value.toString();
    }
    
    /**
     * 根据范围获取集合数据
     * 
     * @param <E>
     * @param list
     * @param fromIndex
     * @param toIndex
     * @return
     */
    public static <E> List<E> subList(List<E> list, int fromIndex, int toIndex)
    {
        // if (CollectionUtil.isEmpty(list))
        if (list.isEmpty())
        {
            return new ArrayList<E>();
        }
        int size = list.size();
        if (fromIndex >= size)
        {
            return new ArrayList<E>();
        }
        if (toIndex > size)
        {
            toIndex = size;
        }
        return list.subList(fromIndex, toIndex);
    }
    
    /**
     * 集合分页
     * 
     * @param page
     * @param list
     * @return
     */
    public static Page pageList(Page page, List<?> list)
    {
        if (list == null)
        {
            return page;
        }
        page.setCount(list.size());
        list = StringUtil.subList(list, page.getStart(), page.getEnd());
        page.setData(list);
        return page;
    }
    
    public static String escape(String value)
    {
        if (value == null)
        {
            return "";
        }
        char ch;
        StringBuffer tmp = new StringBuffer();
        tmp.ensureCapacity(value.length() * 6);
        for (int i = 0; i < value.length(); i++)
        {
            ch = value.charAt(i);
            if (Character.isDigit(ch) || Character.isLowerCase(ch) || Character.isUpperCase(ch))
            {
                tmp.append(ch);
            }
            else if (ch < 256)
            {
                tmp.append("%");
                if (ch < 16)
                {
                    tmp.append("0");
                }
                tmp.append(Integer.toString(ch, 16));
            }
            else
            {
                tmp.append("%u");
                tmp.append(Integer.toString(ch, 16));
            }
        }
        return tmp.toString();
    }
    
    public static String unescape(String src)
    {
        StringBuffer tmp = new StringBuffer();
        tmp.ensureCapacity(src.length());
        int lastPos = 0, pos = 0;
        char ch;
        while (lastPos < src.length())
        {
            pos = src.indexOf("%", lastPos);
            if (pos == lastPos)
            {
                if (src.charAt(pos + 1) == 'u')
                {
                    ch = (char)Integer.parseInt(src.substring(pos + 2, pos + 6), 16);
                    tmp.append(ch);
                    lastPos = pos + 6;
                }
                else
                {
                    ch = (char)Integer.parseInt(src.substring(pos + 1, pos + 3), 16);
                    tmp.append(ch);
                    lastPos = pos + 3;
                }
            }
            else
            {
                if (pos == -1)
                {
                    tmp.append(src.substring(lastPos));
                    lastPos = src.length();
                }
                else
                {
                    tmp.append(src.substring(lastPos, pos));
                    lastPos = pos;
                }
            }
        }
        return tmp.toString();
    }
    
    /**
     * 截取固定长度的字符串
     * 
     * @param str
     * @param maxLength
     * @return
     */
    public static String cutOut(String str, int maxLength)
    {
        return StringUtil.cutOut(str, maxLength, "");
    }
    
    /**
     * 截取固定长度的字符串，超长部分用suffix代替，最终字符串真实长度不会超过maxLength.
     * 
     * @param str
     * @param maxLength
     * @param suffix
     * @return
     */
    public static String cutOut(String str, int maxLength, String suffix)
    {
        if (StringUtils.isEmpty(str))
        {
            return null;
        }
        
        int byteIndex = 0;
        int charIndex = 0;
        
        while (charIndex < str.length() && byteIndex <= maxLength)
        {
            char c = str.charAt(charIndex);
            if (c >= 256)
            {
                byteIndex += 2;
            }
            else
            {
                byteIndex++;
            }
            charIndex++;
        }
        
        if (byteIndex <= maxLength)
        {
            return str;
        }
        
        StringBuilder sb = new StringBuilder();
        sb.append(str.substring(0, charIndex));
        sb.append(suffix);
        
        while (getRealLength(sb.toString()) > maxLength)
        {
            sb.deleteCharAt(--charIndex);
        }
        
        return sb.toString();
    }
    
    /**
     * 取得字符串的真实长度，一个汉字长度为两个字节。
     * 
     * @param str 字符串
     * @return 字符串的字节数
     */
    public static int getRealLength(String str)
    {
        if (str == null)
        {
            return 0;
        }
        
        char separator = 256;
        int realLength = 0;
        
        for (int i = 0; i < str.length(); i++)
        {
            if (str.charAt(i) >= separator)
            {
                realLength += 2;
            }
            else
            {
                realLength++;
            }
        }
        return realLength;
    }
    
    /**
     * 把一个字节数组转换为16进制表达的字符串
     * 
     * @param bytes
     * @return
     */
    public static String toHexString(byte[] bytes)
    {
        StringBuilder hexString = new StringBuilder();
        
        for (int i = 0; i < bytes.length; i++)
        {
            hexString.append(enoughZero(Integer.toHexString(bytes[i] & 0xff), 2));
        }
        return hexString.toString();
    }
    
    /**
     * 在字符串str左边补齐0直到长度等于length
     * 
     * @param str
     * @param len
     * @return
     */
    public static String enoughZero(String str, int len)
    {
        while (str.length() < len)
        {
            str = "0" + str;
        }
        return str;
    }
    
    /**
     * 对http参数生成验证码,对参数tree排序，再形成串加上key进行MD5加密
     * 
     * @param httpParamsMap
     * @param md5Key
     * @return
     * @throws Exception
     */
    public static String getHttpParamsSecuryKey(Map<String, String> httpParamsMap, String md5Key)
        throws Exception
    {
        TreeMap<String, String> map = new TreeMap<String, String>(httpParamsMap);
        
        StringBuilder str = new StringBuilder();
        for (Map.Entry<String, String> e : map.entrySet())
        {
            str.append(e.getKey()).append("=").append(e.getValue()).append("&");
        }
        
        if (!map.isEmpty())
        {
            str.deleteCharAt(str.length() - 1);
        }
        
        str.append(md5Key);
        return StringUtil.md5(str.toString());
    }
    
    public static void main(String[] args)
    {
        try
        {
            String s = StringUtil.encodeURI("测试");
            System.out.println(s);
            System.out.println(StringUtil.decodeURI(s));
            System.out.println("MD5加密:" + StringUtil.md5("ssssssss"));
            
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
    }
}
