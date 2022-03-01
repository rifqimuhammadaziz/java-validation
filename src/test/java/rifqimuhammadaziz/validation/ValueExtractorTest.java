package rifqimuhammadaziz.validation;

import org.junit.jupiter.api.Test;
import rifqimuhammadaziz.validation.container.Data;
import rifqimuhammadaziz.validation.container.DataInteger;
import rifqimuhammadaziz.validation.container.Entry;

public class ValueExtractorTest extends AbstractValidatorTest{

    // validate data single generic type
    @Test
    void testSampleData() {
        SampleData data = new SampleData();
        data.setData(new Data<>());
        data.getData().setData("   "); // blank data

        validate(data);
    }

    // validate data multiple generic type
    @Test
    void testSampleEntry() {
        SampleEntry sampleEntry = new SampleEntry();
        sampleEntry.setEntry(new Entry<>());
        sampleEntry.getEntry().setKey(""); // blank data
        sampleEntry.getEntry().setValue(""); // blank data

        validate(sampleEntry);
    }

    // validate data non generic
    @Test
    void testSampleDataInteger() {
        SampleDataInteger sampleDataInteger = new SampleDataInteger();
        sampleDataInteger.setData(new DataInteger());
        sampleDataInteger.getData().setData(0);

        validate(sampleDataInteger);
    }
}
