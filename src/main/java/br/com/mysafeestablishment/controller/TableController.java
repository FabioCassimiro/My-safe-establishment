package br.com.mysafeestablishment.controller;

import br.com.mysafeestablishment.api.client.MySafeEstablishmentClient;
import br.com.mysafeestablishment.api.domain.TableEstablishment;
import br.com.mysafeestablishment.api.response.MessageResponse;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/private")
@CrossOrigin
public class TableController {

    private final MySafeEstablishmentClient api;

    public TableController() {
        this.api = new MySafeEstablishmentClient();
    }

    @GetMapping("/table/{id}")
    public TableEstablishment tableById(@PathVariable() Long id) throws Exception {
        return api.tableById(id);
    }

    @GetMapping("/tables")
    public ArrayList<TableEstablishment> allTables() throws Exception {
        return api.allTables();
    }

    @PostMapping("/table/register")
    public TableEstablishment registerTables(@RequestBody TableEstablishment table) throws Exception {
        return api.registerTable(table);
    }

    @PutMapping("/table/update")
    public TableEstablishment updateTables(@RequestBody TableEstablishment table) throws Exception {
        return api.updateTable(table);
    }

    @DeleteMapping("table/delete/{id}")
    public MessageResponse deleteTables(@PathVariable() Long id) throws Exception {
        return api.delectTable(id);
    }

    @GetMapping("/table")
    public List<TableEstablishment> tableByNumberSeats(@RequestParam(name = "numberSeats") Integer numberSeats) throws Exception {
        return api.tableByNumberSeats(numberSeats);
    }
}
