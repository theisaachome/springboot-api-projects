CREATE SCHEMA IF NOT EXISTS ecomm;

CREATE TABLE IF NOT EXISTS ecomm.cart(
    id uuid NOT NULL ,
    user_id uuid NOT NULL ,
    FOREIGN KEY (user_id) REFERENCES ecomm.user(id),
    PRIMARY KEY (id)
);

CREATE TABLE IF NOT EXISTS ecomm.cart_item(
    cart_id uuid NOT NULL ,
    item_id uuid NOT NULL ,
    FOREIGN KEY (cart_id) REFERENCES ecomm.cart(id),
    FOREIGN KEY (item_id) REFERENCES ecomm.item(id)
);
