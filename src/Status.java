public enum Status {
    PLACE_AN_ORDER("Place an ordered"),
    READY_TO_SEND("Ready to send"),
    ON_WAY("On way"),
    RESOLVED("Resolved"),
    CANCELED("Canceled");

    private String statusName;

    Status(String statusName) {
        this.statusName = statusName;
    }

    public String getStatusName() {
        return statusName;
    }

    public void setStatusName(String statusName) {
        this.statusName = statusName;
    }
}
