package com.gbusaxin.msscbrewery.web.mappers;

import org.springframework.stereotype.Component;

import java.sql.Timestamp;
import java.time.OffsetDateTime;
import java.time.ZoneOffset;

/**
 * @created : by GBu on 27. 10. 2022, štvrtok
 * @mailto : grigorii.busakhin@software-foundation.sk
 **/
@Component
public class DateMapper {
    public OffsetDateTime asOffsetDateTime(Timestamp ts) {
        if (ts == null)
            return null;
        return OffsetDateTime.of(ts.toLocalDateTime().getYear(), ts.toLocalDateTime().getMonthValue(),
                ts.toLocalDateTime().getDayOfMonth(), ts.toLocalDateTime().getHour(), ts.toLocalDateTime().getMinute(),
                ts.toLocalDateTime().getSecond(), ts.toLocalDateTime().getNano(), ZoneOffset.UTC);
    }

    public Timestamp asTimestamp(OffsetDateTime dt) {
        if (dt == null)
            return null;
        return Timestamp.valueOf(dt.atZoneSameInstant(ZoneOffset.UTC).toLocalDateTime());
    }
}
