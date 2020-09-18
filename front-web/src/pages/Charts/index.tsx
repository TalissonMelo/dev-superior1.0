import React, { useEffect, useState } from 'react'
import Filters from '../../components/Filters'
import './style.css'
import { barOptions, pieOptions } from './chart-options'
import Chart from 'react-apexcharts';
import axios from 'axios';
import { buildBarSeries, getGenderChartData, getPlatformChartData } from './helpers'

type PieChartData = { 
    labels: string[]
    series: number[]
}

type barChartData = {
    x: string;
    y: number;
}

const initialPieData = {
   labels: [],
   series: []
}

const BASE_URL = 'http://localhost:8080'

const Charts = () => {

    const [barChartData, setBarChartdata] = useState<barChartData[]>([]);
    const [platformData, setplatformData] = useState<PieChartData>(initialPieData);
    const [genderData, setGenderData] = useState<PieChartData>(initialPieData);

    useEffect(() => {

       async function getData(){
            const recordsResponse = await axios.get(`${BASE_URL}/records`);
            const gamesResponse = await axios.get(`${BASE_URL}/games`);

            const barData = buildBarSeries(gamesResponse.data, recordsResponse.data.content);
            setBarChartdata(barData)

            const platformChartData = getPlatformChartData(recordsResponse.data.content);
            setplatformData(platformChartData);

            const genreChartData = getGenderChartData(recordsResponse.data.content);
            setGenderData(genreChartData);
        }

        getData();
    }, [])

    return (
        <div className="page-container">
            <Filters link="/records" linkText="VER TABELA" />
            <div className="chart-container">
                <div className="top-related">
                    <h1 className="top-related-title">
                        Jogos mais votados.
                    </h1>
                    <div className="game-container">
                        <Chart options={barOptions}
                            type="bar"
                            width="600"
                            height="600"
                            series={[{ data: barChartData }]} />
                    </div>
                </div>

                <div className="charts">
                    <div className="platform-chart">
                        <h2 className="chart-title">Plataformas</h2>
                        <Chart
                            options={{ ...pieOptions, labels: platformData?.labels }}
                            type="donut" series={platformData?.series} width="350"
                        />
                    </div>
                    <div className="gender-chart">
                        <h2 className="chart-title">Gêneros</h2>
                        <Chart
                            options={{ ...pieOptions, labels: genderData?.labels }}
                            type="donut" series={genderData?.series} width="350"
                        />
                    </div>
                </div>
            </div>
        </div>

    )
}

export default Charts;