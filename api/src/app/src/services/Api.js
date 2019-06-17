import axios from 'axios'

const headers = {
    'Access-Control-Allow-Origin' : process.env.NODE_ENV == 'development' ? '*' : ''
}

export default {
    get(url,param) {
        return axios({
            method: 'get',
            url: url,
            headers: headers,
            params: param
        }).then(result => {
            return result.data
        }).catch(err => {
            console.log(JSON.stringify(err))
        })
    },
    post(url,param) {
        return axios({
            method: 'post',
            url: url,
            headers: headers,
            params: param
        }).then(result => {
            console.log(result);
            return result.data
        }).catch(err => {
            console.log("error??");
            console.log(JSON.stringify(err))
        })
    },
    delete(url,param) {
        return axios({
            method: 'delete',
            url: url,
            headers: headers,
            params: param
        }).then(result => {
            console.log(result);
            return result.data
        }).catch(err => {
            console.log("error??");
            console.log(JSON.stringify(err))
        })
    }

}