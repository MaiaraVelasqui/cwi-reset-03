package br.com.cwi.reset.maiaraalegrevelasquihiller.service;

import br.com.cwi.reset.maiaraalegrevelasquihiller.exception.*;
import br.com.cwi.reset.maiaraalegrevelasquihiller.model.Estudio;
import br.com.cwi.reset.maiaraalegrevelasquihiller.repository.EstudioRepository;
import br.com.cwi.reset.maiaraalegrevelasquihiller.request.EstudioRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

import static java.util.Objects.isNull;

@Service
public class EstudioService {
    
    @Autowired
    private EstudioRepository estudioRepository;

    public void criarEstudio(EstudioRequest estudioRequest) throws Exception {


        List<Estudio> estudiosCadastrados = (List<Estudio>) estudioRepository.findAll();

        for (Estudio estudioCadastrado : estudiosCadastrados) {
            if (estudioCadastrado.getNome().equalsIgnoreCase(estudioRequest.getNome())) {
                throw new CadastroDuplicadoException(TipoDominioException.ESTUDIO.getSingular(), estudioRequest.getNome());
            }
        }

        Integer idGerado = estudiosCadastrados.size() + 1;

        Estudio estudio = new Estudio(idGerado, estudioRequest.getNome(), estudioRequest.getDescricao(), estudioRequest.getDataCriacao(), estudioRequest.getStatusAtividade());


        estudioRepository.save(estudio);
    }

    public List<Estudio> consultarEstudios(String filtroNome) throws Exception {
        final List<Estudio> estudiosCadastrados = (List<Estudio>) estudioRepository.findAll();
        final List<Estudio> estudios = new ArrayList<>();

        if (estudiosCadastrados.isEmpty()) {
            throw new ListaVaziaException(TipoDominioException.ESTUDIO.getSingular(), TipoDominioException.ESTUDIO.getPlural());
        }

        if (!isNull(filtroNome)) {
            for (Estudio estudio : estudiosCadastrados) {
                if (estudio.getNome().toLowerCase(Locale.ROOT).contains(filtroNome.toLowerCase(Locale.ROOT))) {
                    estudios.add(estudio);
                }
            }
        } else {
            estudios.addAll(estudiosCadastrados);
        }

        if (estudios.isEmpty()) {
            throw new FiltroNomeNaoEncontrado("Estúdio", filtroNome);
        }

        return estudios;
    }

    public Estudio consultarEstudio(Integer id) throws Exception {
        if (isNull(id)) {
            throw new IdNaoInformado();
        }

        List<Estudio> all = (List<Estudio>) estudioRepository.findAll();
        return all
                .stream().filter(e -> e.getId().equals(id))
                .findFirst()
                .orElseThrow(() ->
                        new ConsultaIdInvalidoException(
                                TipoDominioException.ESTUDIO.getSingular(),
                                id)
                );
    }
}
