/*
 * Copyright 2017 NAVER Corp.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.navercorp.pinpoint.web.vo.stat.chart.application;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.navercorp.pinpoint.common.server.bo.stat.join.JoinActiveTraceBo;
import com.navercorp.pinpoint.web.view.ActiveTracePointSerializer;
import com.navercorp.pinpoint.web.vo.chart.Point;

/**
 * @author minwoo.jung
 */
@JsonSerialize(using = ActiveTracePointSerializer.class)
public class ActiveTracePoint implements Point {

    private final long xVal;
    private final int yValForMin;
    private final String agentIdForMin;
    private final int yValForMax;
    private final String agentIdForMax;
    private final int yValForAvg;

    public ActiveTracePoint(long xVal, int yValForMin, String agentIdForMin, int yValForMax, String agentIdForMax, int yValForAvg) {
        this.xVal = xVal;
        this.yValForMin = yValForMin;
        this.agentIdForMin = agentIdForMin;
        this.yValForMax = yValForMax;
        this.agentIdForMax = agentIdForMax;
        this.yValForAvg = yValForAvg;
    }

    public int getyValForMin() {
        return yValForMin;
    }

    public String getAgentIdForMin() {
        return agentIdForMin;
    }

    public int getyValForMax() {
        return yValForMax;
    }

    public String getAgentIdForMax() {
        return agentIdForMax;
    }

    public int getyValForAvg() {
        return yValForAvg;
    }

    @Override
    public long getxVal() {
        return xVal;
    }

    public static class UncollectedActiveTracePointCreator implements UncollectedPointCreator<ActiveTracePoint> {
        @Override
        public ActiveTracePoint createUnCollectedPoint(long xVal) {
            return new ActiveTracePoint(xVal, JoinActiveTraceBo.UNCOLLECTED_VALUE, JoinActiveTraceBo.UNKNOWN_AGENT, JoinActiveTraceBo.UNCOLLECTED_VALUE, JoinActiveTraceBo.UNKNOWN_AGENT, JoinActiveTraceBo.UNCOLLECTED_VALUE);
        }
    }
}
