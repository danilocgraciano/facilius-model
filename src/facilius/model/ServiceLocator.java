package facilius.model;

import facilius.model.service.AulaService;
import facilius.model.service.CidadeService;
import facilius.model.service.CursoService;
import facilius.model.service.DisciplinaService;
import facilius.model.service.FrequenciaService;
import facilius.model.service.InstituicaoService;
import facilius.model.service.MaterialService;
import facilius.model.service.TipoNotaService;
import facilius.model.service.TurmaService;
import facilius.model.service.TurmaTipoNotaService;
import facilius.model.service.UsuarioCursoService;
import facilius.model.service.UsuarioCursoTurmaService;
import facilius.model.service.UsuarioService;
import facilius.model.service.ValorNotaService;

public class ServiceLocator {

	public static AulaService getAulaService() {
		throw new UnsupportedOperationException();
	}

	public static CidadeService getCidadeService() {
		throw new UnsupportedOperationException();
	}

	public static CursoService getCursoService() {
		throw new UnsupportedOperationException();
	}

	public static DisciplinaService getDisciplinaService() {
		throw new UnsupportedOperationException();
	}

	public static FrequenciaService getFrequenciaService() {
		throw new UnsupportedOperationException();
	}

	public static InstituicaoService getInstituicaoService() {
		throw new UnsupportedOperationException();
	}

	public static MaterialService getMaterialService() {
		throw new UnsupportedOperationException();
	}

	public static TipoNotaService getTipoNotaService() {
            return new TipoNotaService();
	}

	public static TurmaService getTurmaService() {
		throw new UnsupportedOperationException();
	}

	public static TurmaTipoNotaService getTurmaTipoNotaService() {
		throw new UnsupportedOperationException();
	}

	public static UsuarioCursoService getUsuarioCursoService() {
		throw new UnsupportedOperationException();
	}

	public static UsuarioCursoTurmaService getUsuarioCursoTurmaService() {
		throw new UnsupportedOperationException();
	}

	public static UsuarioService getUsuarioService() {
		throw new UnsupportedOperationException();
	}

	public static ValorNotaService getValorNotaservice() {
		throw new UnsupportedOperationException();
	}
}