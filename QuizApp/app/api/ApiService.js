import axios from 'axios';

export default class ApiService {

  static timeout = 30000;
  static headers = {
    'Accept': 'application/json',
    'Content-Type': 'application/json',
    'X-Requested-With': 'XMLHttpRequest',
    'Accept-Language': 'es',
  };

  constructor() {
    this.apiURL = 'http://localhost:8080/api';

    this.api = axios.create({
      baseURL: this.apiURL,
      timeout: this.constructor.timeout,
      headers: {
        ...this.constructor.headers,
      },
    });

    this.api.interceptors.response.use(
      (response) => response.data,
      (error) => {
        const { response } = error;

        if (!response) {
          return Promise.reject(error);
        }

        const httpError = new Error();
        httpError.message = `Error: ${response.status} (${response.statusText})`;
        httpError.statusCode = response.status;
        httpError.statusText = response.statusText;
        httpError.headers = response.headers;

        if (typeof response.data === 'object' && Object.keys(response.data).length > 0) {
          httpError.message = response.data.message;
          httpError.errors = response.data.errors;
        }

        return Promise.reject(httpError);
      }
    );
  }

  getMusicalStyles(...args) {
    return this.api.get('/musical-styles', ...args);
  }

  getQuizResults(...args) {
    return this.api.get('/quiz/results', ...args);
  }

  sendQuiz(data) {
    return this.api.post('/quiz', data);
  }
}
