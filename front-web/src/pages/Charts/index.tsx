import React from 'react'
import Filters from '../../components/Filters'
import './style.css'
import { barOptions, pieOptions } from './chart-options'
import Chart from 'react-apexcharts';

const chartData = [
    {
        x: 'Talisson Melo',
        y: 10
    }
]


const Charts = () => {
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
                            width="500"
                            height="100"
                            series={[{ data: chartData }]} />
                    </div>
                </div>

                <div className="charts">
                    <div className="platform-chart">
                        <h2 className="chart-title">Plataformas</h2>
                        <Chart
                            options={{ ...pieOptions, labels: ['Talisson Melo', 'Tales Melo'] }}
                            type="donut" series={[90, 10]} width="350"
                        />
                    </div>
                    <div className="gender-chart">
                        <h2 className="chart-title">Gêneros</h2>
                        <Chart
                            options={{ ...pieOptions, labels: ['Talisson Melo', 'Tales Melo'] }}
                            type="donut" series={[60, 40]} width="350"
                        />
                    </div>
                </div>
            </div>
        </div>

    )
}

export default Charts;