package rifqimuhammadaziz.validation.extractor;

import jakarta.validation.valueextraction.ExtractedValue;
import jakarta.validation.valueextraction.ValueExtractor;
import rifqimuhammadaziz.validation.container.Data;

public class DataValueExtractor implements ValueExtractor<Data<@ExtractedValue ?>> {

    @Override
    public void extractValues(Data<?> originalValue, ValueReceiver receiver) {
        Object data = originalValue.getData();
        receiver.value(null, data);
    }
}
