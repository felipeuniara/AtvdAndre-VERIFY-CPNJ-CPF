import org.example.DocumentoValidator;
import org.junit.Assert;
import org.junit.Test;

public class DocumentoValidatorTest {

    private final DocumentoValidator validator =
            new DocumentoValidator();

    // TESTES CPF

    @Test
    public void ValidarCpfCorreto() {

        Assert.assertTrue(
                validator.validarCpf("52998224725")
        );
    }

    @Test
    public void ValidarCpfFormatado() {

        Assert.assertTrue(
                validator.validarCpf("529.982.247-25")
        );
    }

    @Test
    public void RejeitarCpfComDigitoIncorreto() {

        Assert.assertFalse(
                validator.validarCpf("52998224724")
        );
    }

    @Test
    public void RejeitarCpfComTodosDigitosIguais() {

        Assert.assertFalse(
                validator.validarCpf("11111111111")
        );
    }

    @Test
    public void RejeitarCpfComQuantidadeIncorretaDeDigitos() {

        Assert.assertFalse(
                validator.validarCpf("123456789")
        );
    }

    // TESTES CNPJ

    @Test
    public void ValidarCnpjCorreto() {

        Assert.assertTrue(
                validator.validarCnpj("11222333000181")
        );
    }

    @Test
    public void ValidarCnpjFormatado() {

        Assert.assertTrue(
                validator.validarCnpj("11.222.333/0001-81")
        );
    }

    @Test
    public void RejeitarCnpjComDigitoIncorreto() {

        Assert.assertFalse(
                validator.validarCnpj("11222333000182")
        );
    }

    @Test
    public void RejeitarCnpjComTodosDigitosIguais() {

        Assert.assertFalse(
                validator.validarCnpj("11111111111111")
        );
    }

    @Test
    public void RejeitarCnpjComQuantidadeIncorretaDeDigitos() {

        Assert.assertFalse(
                validator.validarCnpj("123456789")
        );
    }

    // OUTROS TESTES

    @Test
    public void RejeitarCpfNulo() {

        Assert.assertFalse(
                validator.validarCpf(null)
        );
    }

    @Test
    public void RejeitarCnpjNulo() {

        Assert.assertFalse(
                validator.validarCnpj(null)
        );
    }
}