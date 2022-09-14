package pl.mlisowski.rest.items.domain;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
public class Item {

    private String id;
    private String name;
    private String description;
    private String price;
    private Owner owner;

}
