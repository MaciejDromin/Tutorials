package pl.mlisowski.rest.items.web;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import pl.mlisowski.rest.items.domain.Item;
import pl.mlisowski.rest.items.domain.ItemUpdateDto;
import pl.mlisowski.rest.items.web.query.QueryDto;

import java.util.List;

@RestController
@RequestMapping("/items")
public class ItemController {

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public List<Item> getAll(@RequestParam String name, @RequestParam double price) {
        return List.of();
    }

    @GetMapping("/{itemId}")
    public Item getItem(@PathVariable String itemId) {
        return new Item();
    }

    @GetMapping("/{itemId}/owners/{ownerId}")
    public Item getItemInOwnerInventory(@PathVariable String itemId, @PathVariable String ownerId) {
        return new Item();
    }

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(code = HttpStatus.CREATED)
    public Item createItem(@RequestBody Item item) {
        return new Item();
    }

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
    public List<Item> queryItems(@RequestBody QueryDto query) {
        return List.of();
    }

    @DeleteMapping(path = "/{itemId}")
    public void deleteItem(@PathVariable String itemId) {
        // Delete item
    }

    @PutMapping(path = "/{itemId}")
    public Item updateItem(@PathVariable String itemId, @RequestBody Item item) {
        return new Item();
    }

    @PatchMapping(path = "/{itemId}")
    public Item updateItemPatch(@PathVariable String itemId, @RequestBody ItemUpdateDto itemUpdate) {
        return new Item();
    }

}
