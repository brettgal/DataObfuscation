import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

//@JsonIgnoreProperties(ignoreUnknown=true)
public class PortfolioSummary {
    String portfolioId;
    String code;
    String displayName;
    String accountType;
    String type;
    String openDate;
    String closeDate;
    Boolean discretionary;
    String taxId;
    String currency;
    String taxStatus;
    String accountStatus;
    String investmentStrategyId;
    String investmentStrategy;
    String managerId;
    String manager;
    Boolean isLeadPortfolio;
    String taxStatusDescription;
    int directNoteCount;
    int indirectNoteCount;
    String closingMethod;
    String sleeveStrategyName;
    String SleeveStrategyCode;
    String sleeveStrategySecuritySymbol;
    String sleeveStrategySecurityId;
    Boolean sleeveStrategyISSMA;

    public String getPortfolioId() {
        return portfolioId;
    }

    public void setPortfolioId(String portfolioId) {
        this.portfolioId = portfolioId;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getDisplayName() {
        return displayName;
    }

    public void setDisplayName(String displayName) {
        this.displayName = displayName;
    }

    public String getAccountType() {
        return accountType;
    }

    public void setAccountType(String accountType) {
        this.accountType = accountType;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getOpenDate() {
        return openDate;
    }

    public void setOpenDate(String openDate) {
        this.openDate = openDate;
    }

    public String getCloseDate() {
        return closeDate;
    }

    public void setCloseDate(String closeDate) {
        this.closeDate = closeDate;
    }

    public Boolean getDiscretionary() {
        return discretionary;
    }

    public void setDiscretionary(Boolean discretionary) {
        this.discretionary = discretionary;
    }

    public String getTaxId() {
        return taxId;
    }

    public void setTaxId(String taxId) {
        this.taxId = taxId;
    }

    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }

    public String getTaxStatus() {
        return taxStatus;
    }

    public void setTaxStatus(String taxStatus) {
        this.taxStatus = taxStatus;
    }

    public String getAccountStatus() {
        return accountStatus;
    }

    public void setAccountStatus(String accountStatus) {
        this.accountStatus = accountStatus;
    }

    public String getInvestmentStrategyId() {
        return investmentStrategyId;
    }

    public void setInvestmentStrategyId(String investmentStrategyId) {
        this.investmentStrategyId = investmentStrategyId;
    }

    public String getInvestmentStrategy() {
        return investmentStrategy;
    }

    public void setInvestmentStrategy(String investmentStrategy) {
        this.investmentStrategy = investmentStrategy;
    }

    public String getManagerId() {
        return managerId;
    }

    public void setManagerId(String managerId) {
        this.managerId = managerId;
    }

    public String getManager() {
        return manager;
    }

    public void setManager(String manager) {
        this.manager = manager;
    }

    public Boolean getLeadPortfolio() {
        return isLeadPortfolio;
    }

    public void setisLeadPortfolio(Boolean isLeadPortfolio) {
        isLeadPortfolio = isLeadPortfolio;
    }

    public String getTaxStatusDescription() {
        return taxStatusDescription;
    }

    public void setTaxStatusDescription(String taxStatusDescription) {
        this.taxStatusDescription = taxStatusDescription;
    }

    public int getDirectNoteCount() {
        return directNoteCount;
    }

    public void setDirectNoteCount(int directNoteCount) {
        this.directNoteCount = directNoteCount;
    }

    public int getIndirectNoteCount() {
        return indirectNoteCount;
    }

    public void setIndirectNoteCount(int indirectNoteCount) {
        this.indirectNoteCount = indirectNoteCount;
    }

    public String getClosingMethod() {
        return closingMethod;
    }

    public void setClosingMethod(String closingMethod) {
        this.closingMethod = closingMethod;
    }

    public String getSleeveStrategyName() {
        return sleeveStrategyName;
    }

    public void setSleeveStrategyName(String sleeveStrategyName) {
        this.sleeveStrategyName = sleeveStrategyName;
    }

    public String getSleeveStrategyCode() {
        return SleeveStrategyCode;
    }

    public void setSleeveStrategyCode(String sleeveStrategyCode) {
        SleeveStrategyCode = sleeveStrategyCode;
    }

    public String getSleeveStrategySecuritySymbol() {
        return sleeveStrategySecuritySymbol;
    }

    public void setSleeveStrategySecuritySymbol(String sleeveStrategySecuritySymbol) {
        this.sleeveStrategySecuritySymbol = sleeveStrategySecuritySymbol;
    }

    public String getSleeveStrategySecurityId() {
        return sleeveStrategySecurityId;
    }

    public void setSleeveStrategySecurityId(String sleeveStrategySecurityId) {
        this.sleeveStrategySecurityId = sleeveStrategySecurityId;
    }

    public Boolean getSleeveStrategyISSMA() {
        return sleeveStrategyISSMA;
    }

    public void setSleeveStrategyISSMA(Boolean sleeveStrategyISSMA) {
        this.sleeveStrategyISSMA = sleeveStrategyISSMA;
    }
}
