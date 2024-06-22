package aicha.pfe.tasks.controller;

import aicha.pfe.tasks.entity.Client;
import aicha.pfe.tasks.service.client.IClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/client")
@CrossOrigin(origins = "*")
public class ClientRestController {

    private final IClientService clientService;

    @Autowired
    public ClientRestController(IClientService clientService) {
        this.clientService = clientService;
    }

    @GetMapping("/retrieve-all-clients")
    @ResponseBody
    public List<Client> getClients() {
        return clientService.retrieve();
    }

    @GetMapping("/retrieve-client/{client-name}")
    @ResponseBody
    public Client findClientByName(@PathVariable("client-name") String clientName) {
        return clientService.findClientByName(clientName);
    }

    @PostMapping("/add-client")
    @ResponseBody
    public Client addClient(@RequestBody Client c) {
        return clientService.add(c);
    }

    @DeleteMapping("/remove-client/{client-id}")
    @ResponseBody
    public void removeClient(@PathVariable("client-id") Long clientId) {
        clientService.delete(clientId);
    }

    @PutMapping("/modify-client")
    @ResponseBody
    public Client modifyClient(@RequestBody Client client) {
        return clientService.update(client);
    }
}


