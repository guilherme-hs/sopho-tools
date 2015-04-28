package com.tenacity.sopho.domain;

import junit.framework.TestCase;
import org.junit.Before;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Calendar;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;

/**
 * Tests the sopho call
 */
public class SophoCallTest extends TestCase {

    public static final int DEFAULT_IBSC = 14;
    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    public static final String FDCRStandardString_EXTEN_TO_EXTERNAL =
            "* #0106112101110553642                            0010001     3134820808          1 3 1400001 016 3 1 000160";
    public static final String FDCRStandardStringWithLessSpaces_EXTEN_TO_EXTERNAL =
            "* #0106112101110553642                            0010001     3134820808          13140000101631000160";
    public static final String FDCRAccountingString_EXTEN_TO_EXTERNAL =
            "* #0107232737684            0 0 0 5 3755        000 000000000160";
    public static final String FDCRAccountingStringWithLessSpaces_EXTEN_TO_EXTERNAL =
            "* #0107232737684            00053755        000000000000160";


    public static final String FDCRStandardString_EXTERNAL_TO_EXTERNAL =
            "* #0180113080110470088001     5121                0011016                         3 3 0100001 002 3 1 000049";
    public static final String FDCRStandardStringWithLessSpaces_EXTERNAL_TO_EXTERNAL =
            "* #0180113080110470088001     5121                0011016                         33010000100231000049";
    public static final String FDCRAccountingString_EXTERNAL_TO_EXTERNAL =
            "* #0181282036678            0 0 0 0                 000000000054";
    public static final String FDCRAccountingStringWithLessSpaces_EXTERNAL_TO_EXTERNAL =
            "* #0181282036678            0000               000000000054";


    public static final String FDCRStandardString_EXTERNAL_TO_EXTEN =
            "* #0118115010114510000001     19982652743         3104                            3 1 0300001 014 3 1 000701";
    public static final String FDCRStandardStringWithLessSpaces_EXTERNAL_TO_EXTEN =
            "* #0118115010114510000001     19982652743         3104                            31030000101431000701";


    public static final String FDCRStandardString_EXTEN_TO_EXTEN =
            "* #0117114012523181444                            1420                            1 1 0100000 004 3 4 000000";
    public static final String FDCRStandardStringWithLessSpaces_EXTEN_TO_EXTEN =
            "* #0117114012523181444                            1420                            11010000000434000000";


    private SophoCall sophoCallExtensionToExternal;
    private SophoCall sophoCallExternalToExtension;
    private SophoCall sophoCallExtensionToExtension;
    private SophoCall sophoCallExternalToExternal;

    @Before
    public void setUp(){
        sophoCallExtensionToExternal = new SophoCall();
        sophoCallExtensionToExternal.setReferenceNumber("0106");
        sophoCallExtensionToExternal.setPartyAtype(SophoPartyType.EXTENSION);
        Calendar calendar = Calendar.getInstance();
        calendar.set(2012, Calendar.OCTOBER, 11, 10, 55);
        sophoCallExtensionToExternal.setDate(calendar.getTime());
        sophoCallExtensionToExternal.setPartyAFarEnd("3642");
        sophoCallExtensionToExternal.setPartyBtype(SophoPartyType.PSTN);
        sophoCallExtensionToExternal.setPartyBRoute("001");
        sophoCallExtensionToExternal.setPartyBLine("0001");
        sophoCallExtensionToExternal.setPartyBFarEnd("3134820808");
        sophoCallExtensionToExternal.setIbsc(DEFAULT_IBSC);
        sophoCallExtensionToExternal.setAnsweredStatus(true);
        sophoCallExtensionToExternal.setAnswerDelay(16);
        sophoCallExtensionToExternal.setAnswerDelayType(SophoAnswerDelayType.BOTH);
        sophoCallExtensionToExternal.setRealeaseReason(SophoRealeaseReason.CLEAR);
        sophoCallExtensionToExternal.setConversationDuration(160);
        sophoCallExtensionToExternal.setDestination("32737684");
        sophoCallExtensionToExternal.setPasswordIndication(SophoPasswordIndication.NORMAL_CALL);
        sophoCallExtensionToExternal.setPrivateCall(false);
        sophoCallExtensionToExternal.setNonPreferedRoute(false);
        sophoCallExtensionToExternal.setCostCentreType(SophoCostCentreType.PID);
        sophoCallExtensionToExternal.setCostCentre("3755");
        sophoCallExtensionToExternal.setAnalysisGroup("000");
        sophoCallExtensionToExternal.setMeteringPulses(0);
        sophoCallExtensionToExternal.setCallDuration(160);


        sophoCallExternalToExternal = new SophoCall();
        sophoCallExternalToExternal.setReferenceNumber("0180");
        sophoCallExternalToExternal.setPartyAtype(SophoPartyType.PSTN);
        calendar = Calendar.getInstance();
        calendar.set(2013, Calendar.AUGUST, 01, 10, 47);
        sophoCallExternalToExternal.setDate(calendar.getTime());
        sophoCallExternalToExternal.setPartyARoute("008");
        sophoCallExternalToExternal.setPartyALine("8001");
        sophoCallExternalToExternal.setPartyAFarEnd("5121");
        sophoCallExternalToExternal.setPartyBtype(SophoPartyType.PSTN);
        sophoCallExternalToExternal.setPartyBRoute("001");
        sophoCallExternalToExternal.setPartyBLine("1016");
        sophoCallExternalToExternal.setPartyBFarEnd("");
        sophoCallExternalToExternal.setIbsc(01);
        sophoCallExternalToExternal.setAnsweredStatus(true);
        sophoCallExternalToExternal.setAnswerDelay(2);
        sophoCallExternalToExternal.setAnswerDelayType(SophoAnswerDelayType.BOTH);
        sophoCallExternalToExternal.setRealeaseReason(SophoRealeaseReason.CLEAR);
        sophoCallExternalToExternal.setConversationDuration(49);
        sophoCallExternalToExternal.setDestination("82036678");
        sophoCallExternalToExternal.setPasswordIndication(SophoPasswordIndication.NORMAL_CALL);
        sophoCallExternalToExternal.setPrivateCall(false);
        sophoCallExternalToExternal.setNonPreferedRoute(false);
        sophoCallExternalToExternal.setCostCentreType(SophoCostCentreType.NO_COST_CENTRE);
        sophoCallExternalToExternal.setCostCentre("    ");
        sophoCallExternalToExternal.setAnalysisGroup("   ");
        sophoCallExternalToExternal.setMeteringPulses(0);
        sophoCallExternalToExternal.setCallDuration(54);


        sophoCallExternalToExtension = new SophoCall();
        sophoCallExternalToExtension.setReferenceNumber("0118");
        calendar = Calendar.getInstance();
        calendar.set(2015, Calendar.JANUARY, 01, 14, 51);
        sophoCallExternalToExtension.setDate(calendar.getTime());
        sophoCallExternalToExtension.setPartyARoute("000");
        sophoCallExternalToExtension.setPartyALine("0001");
        sophoCallExternalToExtension.setPartyAFarEnd("19982652743");
        sophoCallExternalToExtension.setPartyBFarEnd("3104");
        sophoCallExternalToExtension.setPartyAtype(SophoPartyType.PSTN);
        sophoCallExternalToExtension.setPartyBtype(SophoPartyType.EXTENSION);
        sophoCallExternalToExtension.setIbsc(3);
        sophoCallExternalToExtension.setAnsweredStatus(true);
        sophoCallExternalToExtension.setAnswerDelay(14);
        sophoCallExternalToExtension.setAnswerDelayType(SophoAnswerDelayType.BOTH);
        sophoCallExternalToExtension.setRealeaseReason(SophoRealeaseReason.CLEAR);
        sophoCallExternalToExtension.setConversationDuration(701);


        sophoCallExtensionToExtension = new SophoCall();
        sophoCallExtensionToExtension.setReferenceNumber("0117");
        calendar = Calendar.getInstance();
        calendar.set(2014, Calendar.JANUARY, 25, 23, 18);
        sophoCallExtensionToExtension.setDate(calendar.getTime());
        sophoCallExtensionToExtension.setPartyAFarEnd("1444");
        sophoCallExtensionToExtension.setPartyBFarEnd("1420");
        sophoCallExtensionToExtension.setPartyAtype(SophoPartyType.EXTENSION);
        sophoCallExtensionToExtension.setPartyBtype(SophoPartyType.EXTENSION);
        sophoCallExtensionToExtension.setIbsc(1);
        sophoCallExtensionToExtension.setAnsweredStatus(false);
        sophoCallExtensionToExtension.setAnswerDelay(4);
        sophoCallExtensionToExtension.setAnswerDelayType(SophoAnswerDelayType.BOTH);
        sophoCallExtensionToExtension.setRealeaseReason(SophoRealeaseReason.TRANSFER);
        sophoCallExtensionToExtension.setConversationDuration(0);
    }


    //Extension to external
    public void testGetFDCRStandardStringExtensionToExternal() throws Exception {
        assertThat(sophoCallExtensionToExternal.getFDCRStandardString(),
                equalTo(FDCRStandardString_EXTEN_TO_EXTERNAL));
    }

    public void testGetFDCRAccountingStringExtensionToExternal() throws Exception {
        assertThat(sophoCallExtensionToExternal.getFDCRAccountingString(),
                equalTo(FDCRAccountingString_EXTEN_TO_EXTERNAL));
    }

    public void testGetFDCRStandardStringWithLessSpacesExtensionToExternal() throws Exception {
        assertThat(sophoCallExtensionToExternal.getFDCRStandardStringWithLessSpaces(),
                equalTo(FDCRStandardStringWithLessSpaces_EXTEN_TO_EXTERNAL));
    }

    public void testGetFDCRAccountingStringWithLessSpacesExtensionToExternal() throws Exception {
        assertThat(sophoCallExtensionToExternal.getFDCRAccountingStringWithLessSpaces(),
                equalTo(FDCRAccountingStringWithLessSpaces_EXTEN_TO_EXTERNAL));
    }


    //External to external
    public void testGetFDCRStandardStringExternalToExternal() throws Exception {
        assertThat(sophoCallExternalToExternal.getFDCRStandardString(),
                equalTo(FDCRStandardString_EXTERNAL_TO_EXTERNAL));
    }

    public void testGetFDCRAccountingStringExternalToExternal() throws Exception {
        assertThat(sophoCallExternalToExternal.getFDCRAccountingString(),
                equalTo(FDCRAccountingString_EXTERNAL_TO_EXTERNAL));
    }

    public void testGetFDCRStandardStringWithLessSpacesExternalToExternal() throws Exception {
        assertThat(sophoCallExternalToExternal.getFDCRStandardStringWithLessSpaces(),
                equalTo(FDCRStandardStringWithLessSpaces_EXTERNAL_TO_EXTERNAL));
    }

    public void testGetFDCRAccountingStringWithLessSpacesExternalToExternal() throws Exception {
        assertThat(sophoCallExternalToExternal.getFDCRAccountingStringWithLessSpaces(),
                equalTo(FDCRAccountingStringWithLessSpaces_EXTERNAL_TO_EXTERNAL));
    }


    //External to Extension
    public void testGetFDCRStandardStringExternalToExtension() throws Exception {
        assertThat(sophoCallExternalToExtension.getFDCRStandardString(),
                equalTo(FDCRStandardString_EXTERNAL_TO_EXTEN));
    }

    public void testGetFDCRStandardStringWithLessSpacesExternalToExtension() throws Exception {
        assertThat(sophoCallExternalToExtension.getFDCRStandardStringWithLessSpaces(),
                equalTo(FDCRStandardStringWithLessSpaces_EXTERNAL_TO_EXTEN));
    }


    //Extension to Extension
    public void testGetFDCRStandardStringExtensionToExtension() throws Exception {
        assertThat(sophoCallExtensionToExtension.getFDCRStandardString(),
                equalTo(FDCRStandardString_EXTEN_TO_EXTEN));
    }

    public void testGetFDCRStandardStringWithLessSpacesExtensionToExtension() throws Exception {
        assertThat(sophoCallExtensionToExtension.getFDCRStandardStringWithLessSpaces(),
                equalTo(FDCRStandardStringWithLessSpaces_EXTEN_TO_EXTEN));
    }
}