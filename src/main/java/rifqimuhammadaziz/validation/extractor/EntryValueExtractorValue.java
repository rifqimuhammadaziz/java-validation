package rifqimuhammadaziz.validation.extractor;

import jakarta.validation.valueextraction.ExtractedValue;
import jakarta.validation.valueextraction.ValueExtractor;
import rifqimuhammadaziz.validation.container.Entry;

public class EntryValueExtractorValue implements ValueExtractor<Entry<?,@ExtractedValue ?>> {

    @Override
    public void extractValues(Entry<?, ?> originalValue, ValueReceiver receiver) {
        receiver.keyedValue(null, "key", originalValue.getValue());
    }
}
