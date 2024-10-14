package RestaurantManagementSystem;


class Table {
    private int tableNumber;
    private int capacity;
    private TableStatus status;

    public Table(int tableNumber, int capacity) {
        this.tableNumber = tableNumber;
        this.capacity = capacity;
        this.status = TableStatus.AVAILABLE;
    }

    public int getTableNumber() {
        return tableNumber;
    }

    public int getCapacity() {
        return capacity;
    }

    public TableStatus getStatus() {
        return status;
    }

    public void reserve() {
        if (status == TableStatus.AVAILABLE) {
            status = TableStatus.RESERVED;
            System.out.println("Table " + tableNumber + " has been reserved.");
        } else {
            System.out.println("Table " + tableNumber + " is not available.");
        }
    }

    public void occupy() {
        if (status == TableStatus.RESERVED || status == TableStatus.AVAILABLE) {
            status = TableStatus.OCCUPIED;
            System.out.println("Table " + tableNumber + " is now occupied.");
        } else {
            System.out.println("Table " + tableNumber + " is not available.");
        }
    }

    public void release() {
        status = TableStatus.AVAILABLE;
        System.out.println("Table " + tableNumber + " is now available.");
    }
}


