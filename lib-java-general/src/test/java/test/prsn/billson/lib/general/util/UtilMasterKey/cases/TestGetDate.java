/**
 * 
 */
package test.prsn.billson.lib.general.util.UtilMasterKey.cases;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Calendar;

import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import prsn.billson.lib.general.util.UtilMasterKey;
import test.prsn.billson.lib.general.util.UtilMasterKey.IGetTimeAsLong;

/**
 * 
 */
class TestGetDate {

	private static final Logger _LOG = LoggerFactory.getLogger(TestGetDate.class);

	@Test
	void test() {
//		fail("Not yet implemented");

		IGetTimeAsLong i = UtilMasterKey.getAccessByInterface(Calendar.getInstance().getTime(), IGetTimeAsLong.class);

		assertNotNull(i);
		assertNotNull(i.getTime());
		
		_LOG.debug("getTime()|{}", i.getTime());
	}

}
