/**
 * 
 */
package prsn.billson.lib.general.util;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * 
 */
public class UtilMasterKey {

	/**
	 * 
	 */
	public UtilMasterKey() {
	}

	public static <T> T getAccessByInterface(final Object obj, final Class<T> intface) {
		InvocationHandler ih = new InvocationHandler() {

			@Override
			public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
				return obj.getClass().getDeclaredMethod(method.getName(), method.getParameterTypes()).invoke(obj, args);
			}
		};
		// Billson@2019-Apr-17_pm051239 : reference URL:
		// https://stackoverflow.com/questions/211176/interface-is-not-visible-from-classloader-when-using-a-proxy
		return (T) Proxy.newProxyInstance(UtilMasterKey.class.getClassLoader().getSystemClassLoader(),
				new Class[] { intface }, ih);
//		return (T) Proxy.newProxyInstance( obj.getClass().getClassLoader(), new Class[]{intface}, ih );
	}

}
