package br.com.cwi.reset.maiaraalegrevelasquihiller.service;


import br.com.cwi.reset.maiaraalegrevelasquihiller.exception.*;
import br.com.cwi.reset.maiaraalegrevelasquihiller.model.Diretor;
import br.com.cwi.reset.maiaraalegrevelasquihiller.repository.DiretorRepository;
import br.com.cwi.reset.maiaraalegrevelasquihiller.request.DiretorRequest;
import br.com.cwi.reset.maiaraalegrevelasquihiller.validator.BasicInfoRequiredValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

@Service
public class DiretorService {

     @Autowired
     private DiretorRepository diretorRepository;

     public void cadastrarDiretor(final DiretorRequest diretorRequest) throws Exception {
          new BasicInfoRequiredValidator().accept(diretorRequest.getNome(), diretorRequest.getDataNascimento(), diretorRequest.getAnoInicioAtividade(), TipoDominioException.DIRETOR);

          final List<Diretor> diretoresCadastrados = (List<Diretor>) diretorRepository.findAll();

          for (Diretor diretorCadastrado : diretoresCadastrados) {
               if (diretorCadastrado.getNome().equalsIgnoreCase(diretorRequest.getNome())) {
                    throw new CadastroDuplicadoException(TipoDominioException.DIRETOR.getSingular(), diretorRequest.getNome());
               }
          }

          final Integer idGerado = diretoresCadastrados.size() + 1;

          final Diretor diretor = new Diretor(idGerado, diretorRequest.getNome(), diretorRequest.getDataNascimento(), diretorRequest.getAnoInicioAtividade());

          diretorRepository.save(diretor);
     }

     public List<Diretor> listarDiretores(final String filtroNome) throws Exception {
          final List<Diretor> diretoresCadastrados = (List<Diretor>) diretorRepository.findAll();

          if (diretoresCadastrados.isEmpty()) {
               throw new ListaVaziaException(TipoDominioException.DIRETOR.getSingular(), TipoDominioException.DIRETOR.getPlural());
          }

          final List<Diretor> retorno = new ArrayList<>();

          if (filtroNome != null) {
               for (Diretor diretor : diretoresCadastrados) {
                    final boolean containsFilter = diretor.getNome().toLowerCase(Locale.ROOT).contains(filtroNome.toLowerCase(Locale.ROOT));
                    if (containsFilter) {
                         retorno.add(diretor);
                    }
               }
          } else {
               retorno.addAll(diretoresCadastrados);
          }

          if (retorno.isEmpty()) {
               throw new FiltroNomeNaoEncontrado("Diretor", filtroNome);
          }

          return retorno;
     }

     public Diretor consultarDiretor(final Integer id) throws Exception {
          if (id == null) {
               throw new IdNaoInformado();
          }

          final List<Diretor> diretores = (List<Diretor>) diretorRepository.findAll();

          for (Diretor diretor : diretores) {
               if (diretor.getId().equals(id)) {
                    return diretor;
               }
          }

          throw new ConsultaIdInvalidoException(TipoDominioException.DIRETOR.getSingular(), id);
     }
}
