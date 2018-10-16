package ru.naumen.sd40.log.parser;

/**
 * Created by doki on 22.10.16.
 */
public class DataSet
{
    private ActionDoneParser actionsDone = new ActionDoneParser();
    private ErrorParser errors = new ErrorParser();
    private GCParser gc = new GCParser();
    private TopData cpuData = new TopData();

    public DataSet()
    {
    }

    public void parseLine(String line, TimeParser timeParser)
    {
        if (timeParser instanceof SdngTimeParser) {
            actionsDone.parseData(line);
            errors.parseData(line);
        }
        else if (timeParser instanceof GCParser.GCTimeParser)
            gc.parseData(line);
        else if (timeParser instanceof TopParser)
            ((DataParser) timeParser).parseData(line);

    }

    public ActionDoneParser getActionsDone()
    {
        return actionsDone;
    }

    public ErrorParser getErrors()
    {
        return errors;
    }

    public GCParser getGc()
    {
        return gc;
    }

    public TopData cpuData()
    {
        return cpuData;
    }
}
