package com.earthquake.managementPlatform.service;

import com.earthquake.managementPlatform.entities.MissingStatistics;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;

@Component
public class DisasterInfoFactory {
    @Resource
    BasicEarthquakeInformationStorage basicEarthquakeInformationStorage;
    @Resource
    DeathStatisticsStorage deathStatisticsStorage;
    @Resource
    InjuredStatisticsStorage injuredStatisticsStorage;
    @Resource
    MissingStatisticsStorage missingStatisticsStorage;
    @Resource
    CivilStructureStorage civilStructureStorage;
    @Resource
    BrickwoodStructureStorage brickwoodStructureStorage;
    @Resource
    MasonryStructureStorage masonryStructureStorage;
    @Resource
    FrameworkStructureStorage frameworkStructureStorage;
    @Resource
    OtherStructureStorage otherStructureStorage;
    @Resource
    CommDisasterStorage commDisasterStorage;
    @Resource
    TrafficDisasterStorage trafficDisasterStorage;
    @Resource
    WaterDisasterStorage waterDisasterStorage;
    @Resource
    OilDisasterStorage oilDisasterStorage;
    @Resource
    GasDisasterStorage gasDisasterStorage;
    @Resource
    PowerDisasterStorage powerDisasterStorage;
    @Resource
    IrrigationDisasterStorage irrigationDisasterStorage;
    @Resource
    CollapseRecordStorage collapseRecordStorage;
    @Resource
    LandslideRecordStorage landslideRecordStorage;
    @Resource
    DebrisRecordStorage debrisRecordStorage;
    @Resource
    KarstRecordStorage karstRecordStorage;
    @Resource
    CrackRecordStorage crackRecordStorage;
    @Resource
    SettlementRecordStorage settlementRecordStorage;
    @Resource
    OtherRecordStorage otherRecordStorage;
    @Resource
    DisasterPredictionStorage disasterPredictionStorage;

    public DisasterInformationStorage createDisasterInformationStorage(String type){

        DisasterInformationStorage disasterInformationStorage = null;

        if(type.length() == 26)
        {
            disasterInformationStorage = basicEarthquakeInformationStorage;
        }

        else if(type.length() == 3 && (type.equals("202")||type.equals("203")||type.equals("301")))
        {
            disasterInformationStorage = disasterPredictionStorage;
        }

        else if(type.startsWith("551", 12)){
            disasterInformationStorage = basicEarthquakeInformationStorage;
        }
        else if(type.startsWith("111", 12)){
            disasterInformationStorage = deathStatisticsStorage;
        }
        else if(type.startsWith("112", 12)){
            disasterInformationStorage = injuredStatisticsStorage;
        }
        else if(type.startsWith("113", 12)){
            disasterInformationStorage = missingStatisticsStorage;
        }
        else if(type.startsWith("221", 12)){
            disasterInformationStorage = civilStructureStorage;
        }
        else if(type.startsWith("222", 12)){
            disasterInformationStorage = brickwoodStructureStorage;
        }
        else if(type.startsWith("223", 12)){
            disasterInformationStorage = masonryStructureStorage;
        }
        else if(type.startsWith("224", 12)){
            disasterInformationStorage = frameworkStructureStorage;
        }
        else if(type.startsWith("225", 12)){
            disasterInformationStorage = otherStructureStorage;
        }
        else if(type.startsWith("331", 12)){
            disasterInformationStorage = trafficDisasterStorage;
        }
        else if(type.startsWith("332", 12)){
            disasterInformationStorage = waterDisasterStorage;
        }
        else if(type.startsWith("333", 12)){
            disasterInformationStorage = oilDisasterStorage;
        }
        else if(type.startsWith("334", 12)){
            disasterInformationStorage = gasDisasterStorage;
        }
        else if(type.startsWith("335", 12)){
            disasterInformationStorage = powerDisasterStorage;
        }
        else if(type.startsWith("336", 12)){
            disasterInformationStorage = commDisasterStorage;
        }
        else if(type.startsWith("337", 12)){
            disasterInformationStorage = irrigationDisasterStorage;
        }
        else if(type.startsWith("441", 12)){
            disasterInformationStorage = collapseRecordStorage;
        }
        else if(type.startsWith("442", 12)){
            disasterInformationStorage = landslideRecordStorage;
        }
        else if(type.startsWith("443", 12)){
            disasterInformationStorage = debrisRecordStorage;
        }
        else if(type.startsWith("444", 12)){
            disasterInformationStorage = karstRecordStorage;
        }
        else if(type.startsWith("445", 12)){
            disasterInformationStorage = crackRecordStorage;
        }
        else if(type.startsWith("446", 12)){
            disasterInformationStorage = settlementRecordStorage;
        }
        else if(type.startsWith("447", 12)){
            disasterInformationStorage = otherRecordStorage;
        }
        return disasterInformationStorage;
    }
}
