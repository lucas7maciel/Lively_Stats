package com.example.springboot.request;

import java.time.LocalDate;
import java.util.List;

import org.springframework.stereotype.Service;

import com.example.springboot.graph.Graph;
import com.example.springboot.graph.GraphRepo;
import com.example.springboot.user.User;
import com.example.springboot.user.UserRepo;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Service
@RequiredArgsConstructor
@Slf4j
public class RequestService {
    // Ver autowired
    private final RequestRepo requestRepo;
    private final GraphRepo graphRepo;
    private final UserRepo userRepo;

    public List<Request> getAllRequests() {
        return requestRepo.findAll();
    }

    public Request getRequestByNameAndAnimation(String username, String animation) {
        return requestRepo.getRequestByNameAndAnimation(username, animation);
    }

    private Request createRequest(String animation, String username) {
        Request req = new Request();

        Graph graph = graphRepo.getGraphByAnimation(animation);

        if (graph == null) {
            log.info("Falha ao achar gráfico");
            return null;
        }

        User user = userRepo.getUserByName(username);

        if (user == null) {
            // Pegar função
            user = new User();

            user.setName(username);
            user.setFirstUsed(LocalDate.now());
            user.setLastUsed(LocalDate.now());

            userRepo.save(user);
        }

        req.setGraph(graph);
        req.setUser(user);
        req.setCount(0);

        return requestRepo.save(req);
    }

    public Request makeRequest(String animation, String username) {
        Request req = getRequestByNameAndAnimation(username, animation);

        // Consertar isso
        if (req == null) {
            req = createRequest(animation, username);
        }

        if (req == null) {
            log.info("Erro ao fazer request");
            return null;
        }

        req.setCount(req.getCount() + 1);

        // Checa se a request já existe
        //      Se existe edita + 1
        //      Se n existe
        //          Checa se a animação existe
        //              Se não, cancela
        //              Se sim, adiciona

        //          Checa se o user existe
        //              Se não, cria
        //              Se sim, adiciona

        return requestRepo.save(req);
    }
}
