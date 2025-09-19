import http from 'k6/http';
import { check } from 'k6';

export const options = {
  scenarios: {
    eventConfig: {
      executor: 'per-vu-iterations',
      vus: 1000,
      iterations: 10000,
      maxDuration: '2m',
    }
  }
};

export default function () {
  const res = http.get('http://localhost:8080/api/v1/event-config');

  check(res, {
    'Response status is 200': (r) => res.status === 200,
  });
}
