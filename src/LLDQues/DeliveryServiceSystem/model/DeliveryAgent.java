package LLDQues.DeliveryServiceSystem.model;



public class DeliveryAgent {
    private String agentId;
    private String agentName;
    private String pinCodes;
    private boolean isAvailable;

    public DeliveryAgent(String agentName, String pinCodes){
        this.agentId = generateAgentId();
        this.agentName = agentName;
        this.pinCodes = pinCodes;
        this.isAvailable = true;
    }

    public String getAgentId() {
        return agentId;
    }

    public void setAgentId(String agentId) {
        this.agentId = agentId;
    }

    public String getAgentName() {
        return agentName;
    }

    public void setAgentName(String agentName) {
        this.agentName = agentName;
    }

    public String getPinCodes() {
        return pinCodes;
    }

    public void setPinCodes(String pinCodes) {
        this.pinCodes = pinCodes;
    }

    public boolean isAvailable() {
        return isAvailable;
    }

    public void setAvailable(boolean available) {
        isAvailable = available;
    }


    private String generateAgentId() {
        return "AGT" + System.currentTimeMillis();
    }

}

