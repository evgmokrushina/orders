package ru.jenia.orders;

import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.assertThat;

class ValidateInputTest {

    @Test
    public void whenInvalidInput() {
        Output out = new StubOutput();
        Input in = new StubInput(
                new String[] {"one", "1"}
        );
        ValidateInput input = new ValidateInput(out, in);
        int selected = input.askInt("Enter menu:");
        assertThat(selected).isEqualTo(1);
    }

    @Test
    public void whenCorrectInput() {
        Output out = new StubOutput();
        Input in = new StubInput(
                new String[] {"1"}
        );
        ValidateInput input = new ValidateInput(out, in);
        int selected = input.askInt("Enter menu:");
        assertThat(selected).isEqualTo(1);
    }

    @Test
    public void whenMultipleCorrectInput() {
        Output out = new StubOutput();
        Input in = new StubInput(
                new String[] {"0", "4", "6"}
        );
        ValidateInput input = new ValidateInput(out, in);
        int selected0 = input.askInt("Enter menu:");
        assertThat(selected0).isEqualTo(0);
        int selected4 = input.askInt("Enter menu:");
        assertThat(selected4).isEqualTo(4);
        int selected6 = input.askInt("Enter menu:");
        assertThat(selected6).isEqualTo(6);
    }

    @Test
    public void whenNegativeNumber() {
        Output out = new StubOutput();
        Input in = new StubInput(
                new String[] {"-1"}
        );
        ValidateInput input = new ValidateInput(out, in);
        int selected = input.askInt("Enter menu:");
        assertThat(selected).isEqualTo(-1);
    }
}