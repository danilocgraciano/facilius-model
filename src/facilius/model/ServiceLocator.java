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
		return new AulaService();
	}

	public static CidadeService getCidadeService() {
		return new CidadeService();
	}

	public static CursoService getCursoService() {
		return new CursoService();
	}

	public static DisciplinaService getDisciplinaService() {
		return new DisciplinaService();
	}

	public static FrequenciaService getFrequenciaService() {
		return new FrequenciaService();
	}

	public static InstituicaoService getInstituicaoService() {
		return new InstituicaoService();
	}

	public static MaterialService getMaterialService() {
		return new MaterialService();
	}

	public static TipoNotaService getTipoNotaService() {
		return new TipoNotaService();
	}

	public static TurmaService getTurmaService() {
		return new TurmaService();
	}

	public static TurmaTipoNotaService getTurmaTipoNotaService() {
		return new TurmaTipoNotaService();
	}

	public static UsuarioCursoService getUsuarioCursoService() {
		return new UsuarioCursoService();
	}

	public static UsuarioCursoTurmaService getUsuarioCursoTurmaService() {
		return new UsuarioCursoTurmaService();
	}

	public static UsuarioService getUsuarioService() {
		return new UsuarioService();
	}

	public static ValorNotaService getValorNotaservice() {
		return new ValorNotaService();
	}
}