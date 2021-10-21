package br.com.cwi.reset.maiaraalegrevelasquihiller.service;

import br.com.cwi.reset.maiaraalegrevelasquihiller.FakeDatabase;
import br.com.cwi.reset.maiaraalegrevelasquihiller.exception.CadastroDuplicadoException;
import br.com.cwi.reset.maiaraalegrevelasquihiller.exception.CampoNaoInformadoException;
import br.com.cwi.reset.maiaraalegrevelasquihiller.exception.StatusCarreiraNaoInformadoException;
import br.com.cwi.reset.maiaraalegrevelasquihiller.exception.TipoDominioException;
import br.com.cwi.reset.maiaraalegrevelasquihiller.model.Ator;
import br.com.cwi.reset.maiaraalegrevelasquihiller.model.Diretor;
import br.com.cwi.reset.maiaraalegrevelasquihiller.model.Estudio;
import br.com.cwi.reset.maiaraalegrevelasquihiller.request.AtorRequest;
import br.com.cwi.reset.maiaraalegrevelasquihiller.request.EstudioRequest;
import br.com.cwi.reset.maiaraalegrevelasquihiller.validator.BasicInfoRequiredValidator;
import br.com.cwi.reset.maiaraalegrevelasquihiller.validator.EstudioValidacao;

import java.util.List;

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
}

