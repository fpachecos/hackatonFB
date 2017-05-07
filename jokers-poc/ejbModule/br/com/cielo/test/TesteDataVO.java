package br.com.cielo.test;

import java.io.Serializable;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

public class TesteDataVO implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -3861007569964382080L;
	private Integer nuRequest;
	private String requestType;
	private Date dtRequest;
	private String rejectRectReason;
	private Date dtSttlementAjustment;
	private Integer vlGross;
	private String cdUserId;
	private Integer cdTechnologyType;
	private Integer cdStatusRequest;
	private Integer nuCostumer;
	private Integer nuModCostumer;
	private Integer nuBatch;
	private Integer cdMovimentType;
	private Integer cdRefundStatusRequest;
	private Integer cdAjustmentReason;
	private String dcAjustmentComments;
	private Integer nuLoadFileID;
	private Integer cdProduct;
	private String cdEntryType;

	private SimpleDateFormat formatterDiaMesAno = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
	private SimpleDateFormat formatterDiaMesAnoResumido = new SimpleDateFormat("dd/MM/yy");

	public TesteDataVO(){}
	
	public TesteDataVO(List<String> listaCampos) throws ParseException {
		for (int i = 0; i < listaCampos.size(); i++) {
			switch (CamposEnum.values()[i]) {
			case NU_REQUEST:
				this.setNuRequest(Integer.valueOf(listaCampos.get(i)));
				break;
			case CD_REQUEST_TYPE:
				this.setRequestType(listaCampos.get(i));
				break;
			case DH_REQUEST:
				this.setDtRequest(formatterDiaMesAno.parse(listaCampos.get(i)));
				break;
			case CD_REJECT_REASON:
				this.setRejectRectReason(listaCampos.get(i));
				break;
			case DT_SETTLEMENT_ADJUSTMENT:
				this.setDtRequest(formatterDiaMesAnoResumido.parse(listaCampos.get(i)));
				break;
			case VL_GROSS:
				this.setVlGross(Integer.valueOf(listaCampos.get(i)));
				break;
			case CD_USER_ID:
				this.setCdUserId(listaCampos.get(i));
				break;
			case CD_TECHNOLOGY_TYPE:
				this.setCdTechnologyType(Integer.valueOf(listaCampos.get(i)));
				break;
			case CD_STATUS_REQUEST:
				this.setCdStatusRequest(Integer.valueOf(listaCampos.get(i)));
				break;
			case NU_CUSTOMER:
				this.setNuCostumer(Integer.valueOf(listaCampos.get(i)));
				break;
			case NU_MOD_CUSTOMER:
				this.setNuModCostumer(Integer.valueOf(listaCampos.get(i)));
				break;
			case NU_BATCH:
				this.setNuBatch(Integer.valueOf(listaCampos.get(i)));
				break;
			case CD_MOVEMENT_TYPE:
				this.setCdMovimentType(Integer.valueOf(listaCampos.get(i)));
				break;
			case CD_REFUND_STATUS_REQUEST:
				this.setCdRefundStatusRequest(Integer.valueOf(listaCampos.get(i)));
				break;
			case CD_ADJUSTMENT_REASON:
				this.setCdAjustmentReason(Integer.valueOf(listaCampos.get(i)));
				break;
			case DC_ADJUSTMENT_COMMENTS:
				this.setDcAjustmentComments(listaCampos.get(i));
				break;
			case NU_LOAD_FILE_ID:
				this.setNuLoadFileID(Integer.valueOf(listaCampos.get(i)));
				break;
			case CD_PRODUCT:
				this.setCdProduct(Integer.valueOf(listaCampos.get(i)));
				break;
			case CD_ENTRY_TYPE:
				this.setCdEntryType(listaCampos.get(i));
				break;
			default:
				break;
			}
		}

	}

	public Date getDtRequest() {
		return dtRequest;
	}

	public void setDtRequest(Date dtRequest) {
		this.dtRequest = dtRequest;
	}

	public Integer getNuRequest() {
		return nuRequest;
	}

	public void setNuRequest(Integer nuRequest) {
		this.nuRequest = nuRequest;
	}

	public String getRequestType() {
		return requestType;
	}

	public void setRequestType(String requestType) {
		this.requestType = requestType;
	}

	public String getRejectRectReason() {
		return rejectRectReason;
	}

	public void setRejectRectReason(String rejectRectReason) {
		this.rejectRectReason = rejectRectReason;
	}

	public Date getDtSttlementAjustment() {
		return dtSttlementAjustment;
	}

	public void setDtSttlementAjustment(Date dtSttlementAjustment) {
		this.dtSttlementAjustment = dtSttlementAjustment;
	}

	public Integer getVlGross() {
		return vlGross;
	}

	public void setVlGross(Integer vlGross) {
		this.vlGross = vlGross;
	}

	public String getCdUserId() {
		return cdUserId;
	}

	public void setCdUserId(String cdUserId) {
		this.cdUserId = cdUserId;
	}

	public Integer getCdTechnologyType() {
		return cdTechnologyType;
	}

	public void setCdTechnologyType(Integer cdTechnologyType) {
		this.cdTechnologyType = cdTechnologyType;
	}

	public Integer getCdStatusRequest() {
		return cdStatusRequest;
	}

	public void setCdStatusRequest(Integer cdStatusRequest) {
		this.cdStatusRequest = cdStatusRequest;
	}

	public Integer getNuCostumer() {
		return nuCostumer;
	}

	public void setNuCostumer(Integer nuCostumer) {
		this.nuCostumer = nuCostumer;
	}

	public Integer getNuBatch() {
		return nuBatch;
	}

	public void setNuBatch(Integer nuBatch) {
		this.nuBatch = nuBatch;
	}

	public Integer getCdMovimentType() {
		return cdMovimentType;
	}

	public void setCdMovimentType(Integer cdMovimentType) {
		this.cdMovimentType = cdMovimentType;
	}

	public Integer getCdRefundStatusRequest() {
		return cdRefundStatusRequest;
	}

	public void setCdRefundStatusRequest(Integer cdRefundStatusRequest) {
		this.cdRefundStatusRequest = cdRefundStatusRequest;
	}

	public Integer getCdAjustmentReason() {
		return cdAjustmentReason;
	}

	public void setCdAjustmentReason(Integer cdAjustmentReason) {
		this.cdAjustmentReason = cdAjustmentReason;
	}

	public String getDcAjustmentComments() {
		return dcAjustmentComments;
	}

	public void setDcAjustmentComments(String dcAjustmentComments) {
		this.dcAjustmentComments = dcAjustmentComments;
	}

	public Integer getNuLoadFileID() {
		return nuLoadFileID;
	}

	public void setNuLoadFileID(Integer nuLoadFileID) {
		this.nuLoadFileID = nuLoadFileID;
	}

	public Integer getCdProduct() {
		return cdProduct;
	}

	public void setCdProduct(Integer cdProduct) {
		this.cdProduct = cdProduct;
	}

	public String getCdEntryType() {
		return cdEntryType;
	}

	public void setCdEntryType(String cdEntryType) {
		this.cdEntryType = cdEntryType;
	}

	public Integer getNuModCostumer() {
		return nuModCostumer;
	}

	public void setNuModCostumer(Integer nuModCostumer) {
		this.nuModCostumer = nuModCostumer;
	}

}
