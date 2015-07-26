/**
 * 
 */
package in.weq.oneness.util;

/**
 * @author root
 *
 */
public class TextUtils {
    
    /**
     * is text is empty 
     * @param text string parameter
     * @return false if not empty else true
     */
    public static boolean emptyUtil(String text){
        if(text == null || text.length() == 0){
            return true;
        }
        return false;
    }
}