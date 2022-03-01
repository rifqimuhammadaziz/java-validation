package rifqimuhammadaziz.validation;

import jakarta.validation.constraints.Min;
import rifqimuhammadaziz.validation.container.DataInteger;

public class SampleDataInteger {

    @Min(value = 10)
    private DataInteger data;

    public DataInteger getData() {
        return data;
    }

    public void setData(DataInteger data) {
        this.data = data;
    }
}
