package RestaurantManagementSystem;

class Kitchen implements OrderObserver {
    @Override
    public void update(Order order) {
        System.out.println("Kitchen notified: Preparing order for Table " + order.getTable().getTableNumber());
        order.prepare();
    }
}
