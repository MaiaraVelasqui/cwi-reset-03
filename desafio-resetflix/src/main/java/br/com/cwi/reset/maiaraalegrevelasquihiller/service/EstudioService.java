package br.com.cwi.reset.maiaraalegrevelasquihiller.service;

import br.com.cwi.reset.maiaraalegrevelasquihiller.FakeDatabase;
import br.com.cwi.reset.maiaraalegrevelasquihiller.exception.*;
import br.com.cwi.reset.maiaraalegrevelasquihiller.model.Ator;
import br.com.cwi.reset.maiaraalegrevelasquihiller.model.Diretor;
import br.com.cwi.reset.maiaraalegrevelasquihiller.model.Estudio;
import br.com.cwi.reset.maiaraalegrevelasquihiller.request.AtorRequest;
import br.com.cwi.reset.maiaraalegrevelasquihiller.request.EstudioRequest;
import br.com.cwi.reset.maiaraalegrevelasquihiller.validator.BasicInfoRequiredValidator;
import br.com.cwi.reset.maiaraalegrevelasquihiller.validator.EstudioValidacao;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

import static java.util.Objects.isNull;

public class EstudioService {
    private FakeDatabase fakeDatabase;

    public EstudioService(FakeDatabase fakeDatabase) {
        this.fakeDatabase = fakeDatabase;
    }

    public void criarEstudio(EstudioRequest estudioRequest) throws Exception {
        new EstudioValidacao().accept(estudioRequest);


        List<Estudio> estudiosCadastrados = fakeDatabase.recuperaEstudios();

        for (Estudio estudioCadastrado : estudiosCadastrados) {
            if (estudioCadastrado.getNome().equalsIgnoreCase(estudioRequest.getNome())) {
                throw new CadastroDuplicadoException(TipoDominioException.ESTUDIO.getSingular(), estudioRequest.getNome());
            }
        }

        Integer idGerado = estudiosCadastrados.size() + 1;

        Estudio estudio = new Estudio(idGerado, estudioRequest.getNome(), estudioRequest.getDescricao(), estudioRequest.getDataCriacao(), estudioRequest.getStatusAtividade());


        fakeDatabase.persisteEstudio(estudio);
    }

    public List<Estudio> consultarEstudios(String filtroNome) throws Exception {
        final List<Estudio> estudiosCadastrados = fakeDatabase.recuperaEstudios();
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

        return fakeDatabase.recuperaEstudios()
                .stream().filter(e -> e.getId().equals(id))
                .findFirst()
                .orElseThrow(() ->
                        new ConsultaIdInvalidoException(
                                TipoDominioException.ESTUDIO.getSingular(),
                                id)
                );
    }
}
