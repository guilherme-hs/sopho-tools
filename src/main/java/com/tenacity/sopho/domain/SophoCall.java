package com.tenacity.sopho.domain;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Date;
import java.util.Formatter;


/**
 * Represents a call from a sopho pbx
 */
public final class SophoCall {

    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    private static final String DEFAULT_FDCR_STANDARD_REFERENCE_NUMBER = "0100";
    private static final int FDCR_STARNDARD_TYPE = 1;
    private static final String FDCR_DEFAULT_FACILITY_INDICATOR = "0000";
    private static final String TWO_DIGITS_FILED_WITH_ZERO = "%02d";
    private static final String TWELVE_SPACES_FORMAT = "%-12s";
    private static final String TWENTY_SPACES_FORMAT = "%-20s";
    private static final String TWO_SPACES_FORMAT = "%-2s";
    private static final String DEFAULT_FDCR_ACCOUNTING_REFERENCE_NUMBER = "0101";
    private static final int FDCR_ACCOUNTING_TYPE = 2;
    private static final String FDCR_PREFFIX = "* #";
    private static final int SOPHO_YEAR_OFFSET = 2000;
    private static final int JAVA_YEAR_OFFSET = 1900;
    private static final int JAVA_MONTH_OFFSET = 1;

    //kind of uniqueid of the record, but not realy unique
    private String referenceNumber;
    //date of the call
    private Date date;
    //route used by the originator
    private String partyARoute;
    //line number used by the originator
    private String partyALine;
    //identification of the originator
    private String partyAFarEnd;
    //type of the originator
    private SophoPartyType partyAtype;
    //route used by to reach the destination
    private String partyBRoute;
    //route line by to reach the destination
    private String partyBLine;
    //identification of the destination
    private String partyBFarEnd;
    //type of the destination
    private SophoPartyType partyBtype;
    //isbc
    private int ibsc;
    //teoricaly not implemented
    private String facilityIndicator;
    //flags if the call was answered of not
    private boolean answeredStatus;
    //ringing time of the call
    private int answerDelay;
    //type of delay of the call
    private SophoAnswerDelayType answerDelayType;
    //reason of the call release
    private SophoRealeaseReason realeaseReason;
    //time in conversation of the call
    private int conversationDuration;
    //external destination of the call
    private String destination;
    //type of the password of the call
    private SophoPasswordIndication passwordIndication;
    //indicates if it is a private call
    private boolean privateCall;
    //indicated if the call used a non-prefered route
    private boolean nonPreferedRoute;
    //type of the call costcentre
    private SophoCostCentreType costCentreType;
    //cost centre of the call
    private String costCentre;
    //analysis group of the call
    private String analysisGroup;
    //number of metering pulses in the call
    private int meteringPulses;
    //total duration of the call
    private int callDuration;

    @Override
    public String toString() {
        return "ref:" + this.getReferenceNumber() + "|date:" + this.date + "|partyA(" + this.getPartyAtype() + "):" + this.getPartyAFarEnd() + "|partyB(" + this.getPartyBtype() + "):" + this.getPartyBFarEnd() + "|dest:" + this.getDestination() + "|destchan:" + this.getPartyBRoute() + this.getPartyBLine() + "|answered:" + this.isAnsweredStatus() + "|ring:" + this.getAnswerDelay() + "|conversation:" + this.getConversationDuration();
    }

    public String getReferenceNumber() {
        return referenceNumber;
    }

    public void setReferenceNumber(String referenceNumber) {
        this.referenceNumber = referenceNumber;
    }

    public Date getDate() {
        return new Date(date.getTime());
    }

    public void setDate(Date date) {
        this.date = new Date(date.getTime());
    }

    public String getPartyARoute() {
        return partyARoute;
    }

    public void setPartyARoute(String partyARoute) {
        this.partyARoute = partyARoute;
    }

    public String getPartyALine() {
        return partyALine;
    }

    public void setPartyALine(String partyALine) {
        this.partyALine = partyALine;
    }

    public String getPartyAFarEnd() {
        return partyAFarEnd;
    }

    public void setPartyAFarEnd(String partyAFarEnd) {
        this.partyAFarEnd = partyAFarEnd;
    }

    public SophoPartyType getPartyAtype() {
        return partyAtype;
    }

    public void setPartyAtype(SophoPartyType partyAtype) {
        this.partyAtype = partyAtype;
    }

    public String getPartyBRoute() {
        return partyBRoute;
    }

    public void setPartyBRoute(String partyBRoute) {
        this.partyBRoute = partyBRoute;
    }

    public String getPartyBLine() {
        return partyBLine;
    }

    public void setPartyBLine(String partyBLine) {
        this.partyBLine = partyBLine;
    }

    public String getPartyBFarEnd() {
        return partyBFarEnd;
    }

    public void setPartyBFarEnd(String partyBFarEnd) {
        this.partyBFarEnd = partyBFarEnd;
    }

    public SophoPartyType getPartyBtype() {
        return partyBtype;
    }

    public void setPartyBtype(SophoPartyType partyBtype) {
        this.partyBtype = partyBtype;
    }

    public int getIbsc() {
        return ibsc;
    }

    public void setIbsc(int ibsc) {
        this.ibsc = ibsc;
    }

    public String getFacilityIndicator() {
        return facilityIndicator;
    }

    public void setFacilityIndicator(String facilityIndicator) {
        this.facilityIndicator = facilityIndicator;
    }

    public boolean isAnsweredStatus() {
        return answeredStatus;
    }

    public void setAnsweredStatus(boolean answeredStatus) {
        this.answeredStatus = answeredStatus;
    }

    public int getAnswerDelay() {
        return answerDelay;
    }

    public void setAnswerDelay(int answerDelay) {
        this.answerDelay = answerDelay;
    }

    public SophoAnswerDelayType getAnswerDelayType() {
        return answerDelayType;
    }

    public void setAnswerDelayType(SophoAnswerDelayType answerDelayType) {
        this.answerDelayType = answerDelayType;
    }

    public SophoRealeaseReason getRealeaseReason() {
        return realeaseReason;
    }

    public void setRealeaseReason(SophoRealeaseReason realeaseReason) {
        this.realeaseReason = realeaseReason;
    }

    public String getDestination() {
        return destination;
    }

    public void setDestination(String destination) {
        this.destination = destination;
    }

    public SophoPasswordIndication getPasswordIndication() {
        return passwordIndication;
    }

    public void setPasswordIndication(SophoPasswordIndication passwordIndication) {
        this.passwordIndication = passwordIndication;
    }

    public boolean isPrivateCall() {
        return privateCall;
    }

    public void setPrivateCall(boolean privateCall) {
        this.privateCall = privateCall;
    }

    public boolean isNonPreferedRoute() {
        return nonPreferedRoute;
    }

    public void setNonPreferedRoute(boolean nonPreferedRoute) {
        this.nonPreferedRoute = nonPreferedRoute;
    }

    public SophoCostCentreType getCostCentreType() {
        return costCentreType;
    }

    public void setCostCentreType(SophoCostCentreType costCentreType) {
        this.costCentreType = costCentreType;
    }

    public String getCostCentre() {
        return costCentre;
    }

    public void setCostCentre(String costCentre) {
        this.costCentre = costCentre;
    }

    public String getAnalysisGroup() {
        return analysisGroup;
    }

    public void setAnalysisGroup(String analysisGroup) {
        this.analysisGroup = analysisGroup;
    }

    public int getMeteringPulses() {
        return meteringPulses;
    }

    public void setMeteringPulses(int meteringPulses) {
        this.meteringPulses = meteringPulses;
    }

    public int getConversationDuration() {
        return conversationDuration;
    }

    public void setConversationDuration(int callDuration) {
        this.conversationDuration = callDuration;
    }

    public int getCallDuration() {
        return callDuration;
    }

    public void setCallDuration(int callDuration) {
        this.callDuration = callDuration;
    }

    /**
     * Returns the SophoCall as a FDCR standard string format
     *
     * @return FDCR Standard String format
     */
    public String getFDCRStandardString() {
        StringBuilder sb = new StringBuilder();
        Formatter formatter = new Formatter(sb);

        formatter.format(FDCR_PREFFIX);

        if (referenceNumber == null) {
            formatter.format(DEFAULT_FDCR_STANDARD_REFERENCE_NUMBER);
        } else {
            formatter.format(referenceNumber);
        }

        formatter.format("%1d", FDCR_STARNDARD_TYPE);

        if (date == null) {
            return null;
        } else {
            formatter.format(TWO_DIGITS_FILED_WITH_ZERO, date.getYear() + JAVA_YEAR_OFFSET - SOPHO_YEAR_OFFSET);
            formatter.format(TWO_DIGITS_FILED_WITH_ZERO, date.getMonth() + JAVA_MONTH_OFFSET);
            formatter.format(TWO_DIGITS_FILED_WITH_ZERO, date.getDate());
            formatter.format(TWO_DIGITS_FILED_WITH_ZERO, date.getHours());
            formatter.format(TWO_DIGITS_FILED_WITH_ZERO, date.getMinutes());
        }

        if (this.getPartyAtype() == SophoPartyType.EXTENSION) {
            formatter.format("%-32s", this.getPartyAFarEnd());
        }
        if ((this.getPartyAtype() == SophoPartyType.PSTN) || (this.getPartyAtype() == SophoPartyType.DPNSS)) {
            formatter.format(TWELVE_SPACES_FORMAT, this.getPartyARoute() + this.getPartyALine());
            if (this.getPartyAFarEnd() != null) {
                formatter.format(TWENTY_SPACES_FORMAT, this.getPartyAFarEnd());
            } else {
                formatter.format(TWENTY_SPACES_FORMAT, "");
            }
        }

        if (this.getPartyBtype() == SophoPartyType.EXTENSION) {
            if (this.getDestination() == null) {
                formatter.format("%-32s", this.getPartyBFarEnd());
            } else {
                formatter.format("%-12s", this.getPartyBFarEnd());
                formatter.format("%-20s", this.getDestination());
            }
        }
        if ((this.getPartyBtype() == SophoPartyType.PSTN) || (this.getPartyBtype() == SophoPartyType.DPNSS)) {
            formatter.format(TWELVE_SPACES_FORMAT, this.getPartyBRoute() + this.getPartyBLine());
            if (this.getPartyBFarEnd() != null) {
                formatter.format(TWENTY_SPACES_FORMAT, this.getPartyBFarEnd());
            } else {
                formatter.format(TWENTY_SPACES_FORMAT, "");
            }
        }

        formatter.format(TWO_SPACES_FORMAT, this.getPartyAtype().ordinal());
        formatter.format(TWO_SPACES_FORMAT, this.getPartyBtype().ordinal());

        formatter.format(TWO_DIGITS_FILED_WITH_ZERO, this.getIbsc());

        formatter.format(FDCR_DEFAULT_FACILITY_INDICATOR);

        formatter.format(TWO_SPACES_FORMAT, (this.answeredStatus) ? 1 : 0);

        formatter.format("%-4s", String.format("%03d", this.getAnswerDelay()));

        formatter.format(TWO_SPACES_FORMAT, this.getAnswerDelayType().ordinal());

        formatter.format(TWO_SPACES_FORMAT, this.getRealeaseReason().ordinal());

        formatter.format("%06d", this.getConversationDuration());

        return formatter.toString();
    }

    /**
     * Returns the SophoCall as a FDCR standard string format with less spaces
     *
     * @return FDCR Standard String format
     */
    public String getFDCRStandardStringWithLessSpaces() {
        StringBuilder sb = new StringBuilder();
        Formatter formatter = new Formatter(sb);

        formatter.format(FDCR_PREFFIX);

        if (referenceNumber == null) {
            formatter.format(DEFAULT_FDCR_STANDARD_REFERENCE_NUMBER);
        } else {
            formatter.format(referenceNumber);
        }

        formatter.format("%1d", FDCR_STARNDARD_TYPE);

        if (date == null) {
            return null;
        } else {
            formatter.format(TWO_DIGITS_FILED_WITH_ZERO, date.getYear() + JAVA_YEAR_OFFSET - SOPHO_YEAR_OFFSET);
            formatter.format(TWO_DIGITS_FILED_WITH_ZERO, date.getMonth() + JAVA_MONTH_OFFSET);
            formatter.format(TWO_DIGITS_FILED_WITH_ZERO, date.getDate());
            formatter.format(TWO_DIGITS_FILED_WITH_ZERO, date.getHours());
            formatter.format(TWO_DIGITS_FILED_WITH_ZERO, date.getMinutes());
        }


        if (this.getPartyAtype() == SophoPartyType.EXTENSION) {
            formatter.format("%-32s", this.getPartyAFarEnd());
        }
        if ((this.getPartyAtype() == SophoPartyType.PSTN) || (this.getPartyAtype() == SophoPartyType.DPNSS)) {
            formatter.format(TWELVE_SPACES_FORMAT, this.getPartyARoute() + this.getPartyALine());
            if (this.getPartyAFarEnd() != null) {
                formatter.format(TWENTY_SPACES_FORMAT, this.getPartyAFarEnd());
            } else {
                formatter.format(TWENTY_SPACES_FORMAT, "");
            }
        }


        if (this.getPartyBtype() == SophoPartyType.EXTENSION) {
            if (this.getDestination() == null) {
                formatter.format("%-32s", this.getPartyBFarEnd());
            } else {
                formatter.format("%-12s", this.getPartyBFarEnd());
                formatter.format("%-20s", this.getDestination());
            }
        }
        if ((this.getPartyBtype() == SophoPartyType.PSTN) || (this.getPartyBtype() == SophoPartyType.DPNSS)) {
            formatter.format(TWELVE_SPACES_FORMAT, this.getPartyBRoute() + this.getPartyBLine());
            if (this.getPartyBFarEnd() != null) {
                formatter.format(TWENTY_SPACES_FORMAT, this.getPartyBFarEnd());
            } else {
                formatter.format(TWENTY_SPACES_FORMAT, "");
            }
        }

        formatter.format("%1d", this.getPartyAtype().ordinal());
        formatter.format("%1d", this.getPartyBtype().ordinal());

        formatter.format(TWO_DIGITS_FILED_WITH_ZERO, this.getIbsc());

        formatter.format(FDCR_DEFAULT_FACILITY_INDICATOR);

        formatter.format("%1d", (this.answeredStatus) ? 1 : 0);

        formatter.format("%-3s", String.format("%03d", this.getAnswerDelay()));

        formatter.format("%1d", this.getAnswerDelayType().ordinal());

        formatter.format("%1d", this.getRealeaseReason().ordinal());

        formatter.format("%06d", this.getConversationDuration());

        return formatter.toString();
    }


    /**
     * Returns the SophoCall as a FDCR standard string format
     *
     * @return FDCR Standard String format
     */
    public String getFDCRAccountingString() {

        if (costCentre == null) return null;

        StringBuilder sb = new StringBuilder();
        Formatter formatter = new Formatter(sb);

        formatter.format(FDCR_PREFFIX);

        if (referenceNumber == null) {
            formatter.format(DEFAULT_FDCR_ACCOUNTING_REFERENCE_NUMBER);
        } else {
            formatter.format("%04d", Integer.parseInt(referenceNumber) + 1);
        }

        formatter.format("%1d", FDCR_ACCOUNTING_TYPE);

        formatter.format(TWENTY_SPACES_FORMAT, this.getDestination());

        formatter.format(TWO_SPACES_FORMAT, this.getPasswordIndication().ordinal());

        formatter.format(TWO_SPACES_FORMAT, this.isPrivateCall() ? 1 : 0);

        formatter.format(TWO_SPACES_FORMAT, this.isNonPreferedRoute() ? 1 : 0);

        formatter.format(TWO_SPACES_FORMAT, this.getCostCentreType().ordinal());

        formatter.format("%-12s", this.getCostCentre());

        formatter.format("%-4s", (this.getAnalysisGroup() == null) ? "" : this.getAnalysisGroup());

        formatter.format("%06d", this.getMeteringPulses());

        formatter.format("%06d", this.getCallDuration());

        return formatter.toString();
    }

    /**
     * Returns the SophoCall as a FDCR standard string format
     *
     * @return FDCR Standard String format
     */
    public String getFDCRAccountingStringWithLessSpaces() {

        if (costCentre == null) return null;

        StringBuilder sb = new StringBuilder();
        Formatter formatter = new Formatter(sb);

        formatter.format(FDCR_PREFFIX);

        if (referenceNumber == null) {
            formatter.format(DEFAULT_FDCR_ACCOUNTING_REFERENCE_NUMBER);
        } else {
            formatter.format("%04d", Integer.parseInt(referenceNumber) + 1);
        }

        formatter.format("%1d", FDCR_ACCOUNTING_TYPE);

        formatter.format(TWENTY_SPACES_FORMAT, this.getDestination());

        formatter.format("%1d", this.getPasswordIndication().ordinal());

        formatter.format("%1d", this.isPrivateCall() ? 1 : 0);

        formatter.format("%1d", this.isNonPreferedRoute() ? 1 : 0);

        formatter.format("%1d", this.getCostCentreType().ordinal());

        formatter.format("%-12s", this.getCostCentre());

        formatter.format("%-3s", ((this.getAnalysisGroup() == null || this.getAnalysisGroup().isEmpty() ||
                this.getAnalysisGroup().equals("   ")) && (this.partyAtype != SophoPartyType.PSTN)) ?
                "000" : this.getAnalysisGroup());

        formatter.format("%06d", this.getMeteringPulses());

        formatter.format("%06d", this.getCallDuration());

        return formatter.toString();
    }

}
