package br.com.cielo.common.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Locale;
import java.util.TimeZone;

import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.math.NumberUtils;
import org.joda.time.LocalDate;

/**
 * Utilitário de datas.
 *
 * @author <a href="mailto:acarazzai@cielo.com.br>acarazzai</a>
 * @version $Id: DateUtils.java 79530 2016-11-14 17:49:30Z eyvdpi $
 */
public final class DateUtils {

    public static final String PATTERN_DATE_FORMAT = "yyMMddHHmmss";
    public static final String PATTERN_DATE_FORMAT_yyyyMMdd = "yyyyMMdd";
    public static final String PATTERN_DATE_FORMAT_yyyyMM = "yyyyMM";

    /** The Constant locale. */
    public static final Locale LOCALE = new Locale("pt", "BR");

    /**
     * Regex para validar se uma data está em um formato válido. Os formatos
     * aceitos estão listados abaixo:
     * <ul>
     * <li>ddMM
     * <li>ddMMyy
     * <li>ddMMyyHHmm
     * <li>ddMMyyHHmmss
     * <li>ddMMyyHHmmssSSS
     * <li>dd/MM
     * <li>dd/MM/yy
     * <li>dd/MM/yy HH:mm
     * <li>dd/MM/yy HH:mm:ss
     * <li>dd/MM/yy HH:mm:ss.SSS
     * <li>ddMMyyyy
     * <li>ddMMyyyyHHmm
     * <li>ddMMyyyyHHmmss
     * <li>ddMMyyyyHHmmssSSS
     * <li>dd/MM/yyyy
     * <li>dd/MM/yyyy HH:mm
     * <li>dd/MM/yyyy HH:mm:ss
     * <li>dd/MM/yyyy HH:mm:ss.SSS
     * <li>MMdd
     * <li>yyMMdd
     * <li>yyMMddHHmm
     * <li>yyMMddHHmmss
     * <li>yyMMddHHmmssSSS
     * <li>MM/dd
     * <li>yy/MM/dd
     * <li>yy/MM/dd HH:mm
     * <li>yy/MM/dd HH:mm:ss
     * <li>yy/MM/dd HH:mm:ss.SSS
     * <li>yyyyMMdd
     * <li>yyyyMMddHHmm
     * <li>yyyyMMddHHmmss
     * <li>yyyyMMddHHmmssSSS
     * <li>yyyy/MM/dd
     * <li>yyyy/MM/dd HH:mm
     * <li>yyyy/MM/dd HH:mm:ss
     * <li>yyyy/MM/dd HH:mm:ss.SSS
     * </ul>
     */
    public static final String DATE_VALIDATION_PATTERN = "\\d{2,4}/?\\d{2}(/?\\d{2,4}"
                    + "(\\s?\\d{2}:?\\d{2}(:?\\d{2}(.?\\d{1,3})?)?)?)?";

    public static final Date INVALID_DATE = null;

    private static final String NULL_STRING = null;

    private static final long DAY_IN_MILLIS = 86400000;

    /**
     * Pattern para formatação de datas no formato Juliano.
     */
    private static final String JULIAN_DATE_PATTERN = "yyDDD";

    /**
     * Construtor privado para evitar instanciação de classe utilitária.
     */
    private DateUtils() {
        throw new AssertionError("Classe utilitaria nao deve ser instanciada");
    }

    /**
     * Enumeração dos campos de uma data.
     *
     * @author <a href="mailto:acarazzai@cielo.com.br>acarazzai</a>
     * @version $Id: DateUtils.java 79530 2016-11-14 17:49:30Z eyvdpi $
     */
    public enum DateType {
        DAY, MONTH, YEAR;
    }

    /**
     * Formata uma data com o pattern informado.
     *
     * @param date
     *            Data desejada
     * @param pattern
     *            Pattern de formatação
     * @return Data formatada com o pattern informado na entrada
     */
    public static String formatString(final Date date, final String pattern) {
        return date == null || StringUtils.isBlank(pattern) ? NULL_STRING : new SimpleDateFormat(pattern,
                        Locale.getDefault()).format(date);
    }

    /**
     * Formata uma data no formato juliano.
     * <p>
     * O formato juliano é composto pelo último dígito do ano, seguido do dia do
     * ano (0-365 ou 0-366, em anos bissextos).
     * <p>
     * Exemplos:
     * <p>
     * <code>10/01/2010 > 10</code> <br>
     * <code>10/01/2014 > 4010</code>
     * <p>
     * <i>* Note que não há padding quando os dígitos mais significativos (à
     * esquerda) são iguais a 0</i>
     *
     * @param julianDate
     *            Data de Processamento a ser formatada
     * @return Representação da data no formato juliano
     */
    public static Integer formatJulianDate(final Date julianDate) {
        return Integer.valueOf(new SimpleDateFormat(JULIAN_DATE_PATTERN, Locale.getDefault()).format(julianDate)
                        .substring(1));
    }

    /**
     * Converte uma data do tipo java.util.Date para o tipo java.sql.Date.
     *
     * @param date
     *            Data a ser convertida
     * @return SQL Date correspondente
     */
    public static java.sql.Date toSqlDate(final Date date) {
        return new java.sql.Date(date.getTime());
    }

    /**
     * Converte uma data do tipo java.util.Date para o tipo java.sql.Timestamp.
     *
     * @param date
     *            Data a ser convertida
     * @return SQL Timestamp correspondente
     */
    public static java.sql.Timestamp toSqlTimestamp(final Date date) {
        return new java.sql.Timestamp(date.getTime());
    }

    /**
     * Retorna a maior data entre as datas informadas.
     *
     * @param a
     *            Primeira Data
     * @param b
     *            Segunda Data
     * @return Maior Data
     */
    public static Date max(final Date a, final Date b) {

        Date maxDate;

        if (a == null) {
            maxDate = b;

        } else if (b == null) {
            maxDate = a;

        } else if (LocalDate.fromDateFields(a).isAfter(LocalDate.fromDateFields(b))) {
            maxDate = a;

        } else {
            maxDate = b;
        }

        return maxDate;
    }

    /**
     * Retorna a maior data entre as datas informadas.
     *
     * @param a
     *            Primeira Data
     * @param b
     *            Segunda Data
     * @return Maior Data
     */
    public static LocalDate max(final LocalDate a, final LocalDate b) {

        LocalDate maxDate;

        if (a == null) {
            maxDate = b;

        } else if (b == null) {
            maxDate = a;

        } else if (a.isAfter(b)) {
            maxDate = a;

        } else {
            maxDate = b;
        }

        return maxDate;
    }

    /**
     * Retorna a menor data entre as datas informadas.
     *
     * @param a
     *            Primeira Data
     * @param b
     *            Segunda Data
     * @return Menor Data
     */
    public static Date min(final Date a, final Date b) {

        Date minDate;

        if (a == null) {
            minDate = b;

        } else if (b == null) {
            minDate = a;

        } else if (LocalDate.fromDateFields(a).isBefore(LocalDate.fromDateFields(b))) {
            minDate = a;

        } else {
            minDate = b;
        }

        return minDate;
    }

    /**
     * Efetua o parse de uma data em formato texto utilizando o pattern
     * informado.
     * <p>
     * Este método é <i>null safe</i>, caso um valor nulo ou branco for
     * informado, será retornado {@code null}.
     * <p>
     * Além disso, o formato do valor informado é validado conforme um dos
     * padrões especificados por {@link #DATE_VALIDATION_PATTERN}. Caso o valor
     * não esteja em um dos formatos considerados válidos ou ocorra erro no
     * parse, também será retornado {@code null}.
     *
     * @param value
     *            Data em formato texto
     * @param pattern
     *            Pattern para conversão
     * @return Data correspondente
     */
    public static Date parse(final String value, final String pattern) {

        Date parsedDate;

        if (StringUtils.isNotBlank(value) && value.matches(DATE_VALIDATION_PATTERN)) {
            parsedDate = doParse(value, pattern);
        } else {
            parsedDate = INVALID_DATE;
        }

        return parsedDate;
    }

    /**
     * Efetua realmente o parse do valor informado.
     *
     * @param value
     *            Data em formato texto
     * @param pattern
     *            Pattern para conversão
     * @return Data correspondente
     */
    private static Date doParse(final String value, final String pattern) {

        Date parsedDate;

        try {
            parsedDate = new SimpleDateFormat(pattern, Locale.getDefault()).parse(value);
        } catch (final ParseException e) {
            parsedDate = INVALID_DATE;
        }

        return parsedDate;
    }

    /**
     * Adiciona ao campo informado da data o valor passado como parâmetro.
     *
     * @param date
     *            Data
     * @param type
     *            Campo que deve ser alterado
     * @param value
     *            Quantidade que deve ser somada
     * @return Data alterada
     */
    public static Date calculateDateFor(final Date date, final DateType type, final int value) {
        LocalDate localDate = LocalDate.fromDateFields(date);

        switch (type) {
            case DAY :
                localDate = localDate.plusDays(value);
                break;

            case MONTH :
                localDate = localDate.plusMonths(value);
                break;

            case YEAR :
                localDate = localDate.plusYears(value);
                break;

            default :
                throw new IllegalArgumentException(String.format(
                                "Tipo de data não reconhecido: %s. Favor usar DAY, MONTH ou YEAR.", type));
        }

        return localDate.toDate();
    }

    /**
     * Método responsável por criar uma data com o primeiro dia do mês anterior
     * com horário zerado.
     *
     * @param date
     *            Tipo: Date
     * @return Data
     */
    public static Date getFirstDayOfPreviousMonthSus(final Date date) {

        if (date == null) {
            throw new IllegalArgumentException("Campo data nao informado");
        }

        final Calendar calendar = Calendar.getInstance(TimeZone.getTimeZone("GMT"));

        calendar.setTime(date);

        if (calendar.get(Calendar.MONTH) > 0) {
            calendar.set(Calendar.MONTH, calendar.get(Calendar.MONTH) - NumberUtils.INTEGER_ONE);
        } else {
            calendar.set(Calendar.MONTH, Calendar.DECEMBER);
            calendar.set(Calendar.YEAR, calendar.get(Calendar.YEAR) - NumberUtils.INTEGER_ONE);
        }

        calendar.set(Calendar.DAY_OF_MONTH, NumberUtils.INTEGER_ONE);
        calendar.set(Calendar.HOUR, NumberUtils.INTEGER_ZERO);
        calendar.set(Calendar.MINUTE, NumberUtils.INTEGER_ZERO);
        calendar.set(Calendar.SECOND, NumberUtils.INTEGER_ZERO);

        return calendar.getTime();
    }

    /**
     * Método responsável por criar uma data com o primeiro dia do mês anterior
     * com horário zerado.
     *
     * @param date
     *            Tipo: Date
     * @return Data
     */
    public static Date getFirstDayOfPreviousMonth(final Date date) {

        if (date == null) {
            throw new IllegalArgumentException("Campo data nao informado");
        }

        final Calendar calendar = Calendar.getInstance();

        calendar.setTime(date);

        calendar.set(Calendar.MONTH, calendar.get(Calendar.MONTH) - NumberUtils.INTEGER_ONE);
        calendar.set(Calendar.DAY_OF_MONTH, NumberUtils.INTEGER_ONE);
        calendar.set(Calendar.HOUR, NumberUtils.INTEGER_ZERO);
        calendar.set(Calendar.MINUTE, NumberUtils.INTEGER_ZERO);
        calendar.set(Calendar.SECOND, NumberUtils.INTEGER_ZERO);

        return calendar.getTime();
    }

    public static Date getFirstDayOfMonth(final Date date, final int addMonths) {
        if (date == null) {
            throw new IllegalArgumentException("Campo data nao informado");
        }

        Calendar firstDay = new GregorianCalendar();
        firstDay.setTime(date);
        firstDay.add(Calendar.MONTH, addMonths);
        firstDay.set(Calendar.DAY_OF_MONTH, firstDay.getMinimum(Calendar.DAY_OF_MONTH));

        return firstDay.getTime();
    }

    /**
     * Método responsavel por criar uma data com o ultimo instante do mes
     * anterior.
     *
     * @param date
     *            tipo Date que representa a data referencia.
     * @return ultimo instante do mês anterior.
     */
    public static Date getlastInstantOfPreviosMonth(final Date date) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);

        calendar.add(Calendar.MONTH, -1);
        calendar.set(Calendar.DAY_OF_MONTH, calendar.getActualMaximum(Calendar.DAY_OF_MONTH));
        calendar.set(Calendar.HOUR, NumberUtils.createInteger("23"));
        calendar.set(Calendar.MINUTE, NumberUtils.createInteger("59"));
        calendar.set(Calendar.SECOND, NumberUtils.createInteger("59"));

        return calendar.getTime();

    }

    /**
     * Método responsável por criar uma data com o primeiro dia do mês com
     * horário 00:00:00.
     *
     * @param date
     *            Tipo: Date
     * @return Data
     */
    public static Date getFirstInstantOfMonth(final Date date) {
        if (date == null) {
            throw new IllegalArgumentException("Campo data nao informado");
        }

        Calendar firstDay = new GregorianCalendar();
        firstDay.setTime(date);
        firstDay.set(Calendar.DAY_OF_MONTH, firstDay.getMinimum(Calendar.DAY_OF_MONTH));
        firstDay.set(Calendar.HOUR, NumberUtils.INTEGER_ZERO);
        firstDay.set(Calendar.MINUTE, NumberUtils.INTEGER_ZERO);
        firstDay.set(Calendar.SECOND, NumberUtils.INTEGER_ZERO);

        return firstDay.getTime();
    }

    /**
     * Método responsável por criar uma data com o último dia do mês com horário
     * 23:59:59.
     *
     * @param date
     *            Tipo: Date
     * @return Data
     */
    public static Date getLastDayOfMonth(final Date date) {

        if (date == null) {
            throw new IllegalArgumentException("Campo data nao informado");
        }

        final Calendar calendar = Calendar.getInstance();

        calendar.setTime(date);

        calendar.set(Calendar.DAY_OF_MONTH, calendar.getActualMaximum(Calendar.DAY_OF_MONTH));
        calendar.set(Calendar.HOUR, NumberUtils.createInteger("23"));
        calendar.set(Calendar.MINUTE, NumberUtils.createInteger("59"));
        calendar.set(Calendar.SECOND, NumberUtils.createInteger("59"));

        return calendar.getTime();
    }

    /**
     * Obtém o último dia do mês com o último horário do dia de acordo com a
     * data informado no parametro.
     * 
     * @param dateTime
     *            Data
     * @return Data com último dia do mês e último horário do dia.
     */
    public static Date getLastDayOfMonthWithLastHour(final Date dateTime) {
        final Calendar cal = Calendar.getInstance();
        cal.setTime(dateTime);
        cal.set(Calendar.DAY_OF_MONTH, cal.getActualMaximum(Calendar.DAY_OF_MONTH));

        return org.apache.commons.lang3.time.DateUtils.addMilliseconds(
                        org.apache.commons.lang3.time.DateUtils.ceiling(cal.getTime(), Calendar.DATE), -1);
    }

    /**
     * Obtém data com último horário do dia de acordo com a data informada no
     * parametro.
     * 
     * @param dateTime
     *            Data
     * @return Data com útimo horário do dia.
     */
    public static Date getLastHourOfDate(final Date dateTime) {
        return org.apache.commons.lang3.time.DateUtils.addMilliseconds(
                        org.apache.commons.lang3.time.DateUtils.ceiling(dateTime, Calendar.DATE), -1);
    }

    /**
     * Obtém data com primeiro horário do dia de acordo com a data informada no
     * parametro.
     *
     * @param dateTime
     *            Data
     * @return Data com primeiro horário do dia. Se a data for nula, será
     *         retornado null
     */
    public static Date getFirstHourOfDateForValidDate(final Date dateTime) {
        if (dateTime == null) {
            return null;
        }
        return org.apache.commons.lang3.time.DateUtils.truncate(dateTime, Calendar.DATE);
    }

    /**
     * Obtém data com primeiro horário do dia de acordo com a data informada no
     * parametro.
     * 
     * @param dateTime
     *            Data
     * @return Data com primeiro horário do dia.
     */
    public static Date getFirstHourOfDate(final Date dateTime) {
        return org.apache.commons.lang3.time.DateUtils.truncate(dateTime, Calendar.DATE);
    }

    /**
     * Verifica se as duas datas se referem à mesma data, desprezando informação
     * de hora.
     *
     * <pre>
     * DateUtils.sameDate(null, null) = false
     * DateUtils.sameDate("16/11/14 12:00", null) = false
     * DateUtils.sameDate(null, "16/11/14 12:00") = false
     * DateUtils.sameDate("16/11/14 12:17:35", "16/11/14 15:45:26") = true
     * DateUtils.sameDate("17/11/14 11:25:51", "16/11/14 15:45:26") = false
     * </pre>
     *
     * @param date
     *            Data para comparação
     * @param otherDate
     *            Data para comparação
     * @return true caso as duas datas se refiram ao mesmo dia, false caso
     *         contrário ou caso uma delas seja nula
     */
    public static boolean sameDate(final Date date, final Date otherDate) {
        return date != null && otherDate != null
                        && LocalDate.fromDateFields(date).equals(LocalDate.fromDateFields(otherDate));
    }

    /**
     * Verifica se a primeira data é antes da segunda
     *
     * @param first
     *            primeira data
     * @param last
     *            segunda data
     * @return verdadeiro se a primeira data for antes da segunda
     */
    public static Boolean isBefore(final Date first, final Date last) {
        return first.compareTo(last) < 0;
    }

    /**
     * Get the difference in days from two dates
     *
     * @param before
     * @param after
     * @return the difference in days
     */
    public static long getDifferenceInDays(final Date before, final Date after) {
        final long millis = before.getTime() - after.getTime();

        return Math.abs(millis / DAY_IN_MILLIS);
    }

    /**
     * Adiciona uma quantidade de dias a data passada
     *
     * @param date
     *            referencia
     * @param amount
     *            quantidade de dias para adicionar
     * @return a nova data
     */
    public static Date addDays(final Date date, final Integer amount) {
        return org.apache.commons.lang3.time.DateUtils.addDays(date, amount);
    }

    /**
     * Recupera o mes da data informada no parametro
     *
     * @param data
     *            se for data atual, devera ser a data contida em
     *            EstacaoTrabalhoTO.unidadeTO.getHorarioUnidade()
     * @return Mes numerico
     */
    public static int getMonth(final Date data) {
        int retorno;
        if (data == null) {
            retorno = -NumberUtils.INTEGER_ONE;
        } else {
            final Calendar calendario = dateToCalendar(data);

            retorno = calendario.get(Calendar.MONTH) + NumberUtils.INTEGER_ONE;
        }
        return retorno;
    }

    /**
     * Obtém o ano representado pela data
     *
     * @param dt
     *            A data a se extrair o ano
     * @return o ano representado pela data
     */
    public static int getYear(final Date dt) {
        int retorno;
        if (dt == null) {
            retorno = -NumberUtils.INTEGER_ONE;
        } else {
            final Calendar calendario = dateToCalendar(dt);

            retorno = calendario.get(Calendar.YEAR);
        }
        return retorno;
    }

    /**
     * Tranforma um tipo Date num tipo Calendar.
     *
     * @param data
     *            parametro do tipo Date a ser convertido
     * @return a data em formato Calendar
     * @throws Exception
     */
    public static Calendar dateToCalendar(final Date data) {
        if (data == null) {
            throw new IllegalArgumentException("Parametro não informado!");
        }

        final Calendar calendar = Calendar.getInstance();
        calendar.setTime(data);

        return calendar;
    }

    /**
     * Recupera o calendario com a localizacao correta.
     *
     * @return Calendar
     */
    public static Calendar getCalendarCurrent() {
        return Calendar.getInstance(LOCALE);
    }

    /**
     * Recupera a data corrente do sistema
     *
     * @return data corrente
     */
    public static Date getDateAtualSystem() {
        return getCalendarCurrent().getTime();
    }

    /**
     * Função que subtrai a quantidade de meses na data informada.
     *
     * @param date
     *            the date
     * @param qtdeMeses
     *            the qtde dias
     * @return Date
     */
    public static Date subtractMonth(final Date date, final int qtdeMeses) {
        return org.apache.commons.lang3.time.DateUtils.addMonths(date, -qtdeMeses);
    }

}
