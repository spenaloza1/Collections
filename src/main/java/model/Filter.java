package model;

public class Filter {

    protected Boolean operationTypeExist;
    protected OperationTypeEnum operationTypeEnum;
    protected Boolean realestateTypeExist;
    protected RealestateTypeEnum realestateTypeEnum;
    protected Boolean statusExist;
    protected StatusEnum statusEnum;

    public Filter(Boolean operationTypeExist, OperationTypeEnum operationTypeEnum, Boolean realestateTypeExist, RealestateTypeEnum realestateTypeEnum, Boolean statusExist, StatusEnum statusEnum) {
        this.operationTypeExist = operationTypeExist;
        this.operationTypeEnum = operationTypeEnum;
        this.realestateTypeExist = realestateTypeExist;
        this.realestateTypeEnum = realestateTypeEnum;
        this.statusExist = statusExist;
        this.statusEnum = statusEnum;
    }

    public Filter() {

    }

    public Boolean getOperationTypeExist() {
        return operationTypeExist;
    }

    public void setOperationTypeExist(Boolean operationTypeExist) {
        this.operationTypeExist = operationTypeExist;
    }

    public OperationTypeEnum getOperationTypeEnum() {
        return operationTypeEnum;
    }

    public void setOperationTypeEnum(OperationTypeEnum operationTypeEnum) {
        this.operationTypeEnum = operationTypeEnum;
    }

    public Boolean getRealestateTypeExist() {
        return realestateTypeExist;
    }

    public void setRealestateTypeExist(Boolean realestateTypeExist) {
        this.realestateTypeExist = realestateTypeExist;
    }

    public RealestateTypeEnum getRealestateTypeEnum() {
        return realestateTypeEnum;
    }

    public void setRealestateTypeEnum(RealestateTypeEnum realestateTypeEnum) {
        this.realestateTypeEnum = realestateTypeEnum;
    }

    public Boolean getStatusExist() {
        return statusExist;
    }

    public void setStatusExist(Boolean statusExist) {
        this.statusExist = statusExist;
    }

    public StatusEnum getStatusEnum() {
        return statusEnum;
    }

    public void setStatusEnum(StatusEnum statusEnum) {
        this.statusEnum = statusEnum;
    }

}
